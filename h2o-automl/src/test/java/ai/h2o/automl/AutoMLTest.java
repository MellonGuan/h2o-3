package ai.h2o.automl;

import org.junit.BeforeClass;
import org.junit.Test;
import water.Key;
import water.fvec.Frame;

import java.util.Date;

public class AutoMLTest extends TestUtil {

  @BeforeClass public static void setup() { stall_till_cloudsize(1); }

  @Test public void airlinesTest() {
    AutoML aml=null;
    Frame fr=null;
    try {
      AutoMLBuildSpec autoMLBuildSpec = new AutoMLBuildSpec();
      fr = parse_test_file("./smalldata/airlines/allyears2k_headers.zip");
      autoMLBuildSpec.input_spec.training_frame = fr._key;
      autoMLBuildSpec.input_spec.response_column = "IsDepDelayed";
      autoMLBuildSpec.build_control.loss = "AUTO";
      autoMLBuildSpec.build_control.stopping_criteria.set_max_runtime_secs(20);

      aml = AutoML.makeAutoML(Key.<AutoML>make(), new Date(), autoMLBuildSpec);
      AutoML.startAutoML(aml);
      aml.get();

    } finally {
      // cleanup
      if(aml!=null) aml.deleteWithChildren();
      if(fr != null) fr.remove();
    }
  }

  @Test public void weatherTest() {
    AutoML aml=null;
    Frame fr=null;
    try {
      AutoMLBuildSpec autoMLBuildSpec = new AutoMLBuildSpec();
      fr = parse_test_file("./smalldata/junit/weather.csv");
      autoMLBuildSpec.input_spec.training_frame = fr._key;
      autoMLBuildSpec.input_spec.response_column = "RainTomorrow";
      autoMLBuildSpec.build_control.loss = "AUTO";
      autoMLBuildSpec.build_control.stopping_criteria.set_max_runtime_secs(20);

      aml = AutoML.makeAutoML(Key.<AutoML>make(), new Date(), autoMLBuildSpec);
      AutoML.startAutoML(aml);
      aml.get();

    } finally {
      // cleanup
      if(aml!=null) aml.deleteWithChildren();
      if(fr != null) fr.remove();
    }
  }

  @Test public void carsTest() {
    AutoML aml=null;
    Frame fr=null;
    try {
      AutoMLBuildSpec autoMLBuildSpec = new AutoMLBuildSpec();
      fr = parse_test_file("./smalldata/junit/cars.csv");
      autoMLBuildSpec.input_spec.training_frame = fr._key;
      autoMLBuildSpec.input_spec.response_column = "economy (mpg)";
      autoMLBuildSpec.build_control.loss = "AUTO";
      autoMLBuildSpec.build_control.stopping_criteria.set_max_runtime_secs(20);

      aml = AutoML.makeAutoML(Key.<AutoML>make(), new Date(), autoMLBuildSpec);
      AutoML.startAutoML(aml);
      aml.get();

    } finally {
      // cleanup
      if(aml!=null) aml.deleteWithChildren();
      if(fr != null) fr.remove();
    }
  }

  @Test public void irisTest() {
    AutoML aml=null;
    Frame fr=null;
    try {
      AutoMLBuildSpec autoMLBuildSpec = new AutoMLBuildSpec();
      fr = parse_test_file("./smalldata/iris/iris.csv");
      autoMLBuildSpec.input_spec.training_frame = fr._key;
      autoMLBuildSpec.input_spec.response_column = fr.lastVecName();
      autoMLBuildSpec.build_control.loss = "AUTO";
      autoMLBuildSpec.build_control.stopping_criteria.set_max_runtime_secs(20);

      aml = AutoML.makeAutoML(Key.<AutoML>make(), new Date(), autoMLBuildSpec);
      AutoML.startAutoML(aml);
      aml.get();

    } finally {
      // cleanup
      if(aml!=null) aml.deleteWithChildren();
      if(fr != null) fr.remove();
    }
  }
}
