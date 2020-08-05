import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.sterniczuk.serwis.CarService;

public class CarServiceTest {

    @Test
    public void analyzeCarByParams_millageNull_throwsIllegalArgumentException(){

        //given
        Integer treadThickness = 3;
        Integer fuelUsage = 5;
        Integer carMillage = null;
        CarService service = new CarService();

        //when

        //then
        Assertions.assertThrows(IllegalArgumentException.class,() ->  service.analyzeCarByParams(treadThickness,fuelUsage,carMillage));
    }
    @Test
    public void analyzeCarByParams_allValuesOk_resultTrue(){

        //given
        Integer treadThickness = 3;
        Integer fuelUsage = 5;
        Integer carMillage = 1500;
        CarService service = new CarService();

        //when
        boolean result = service.analyzeCarByParams(treadThickness,fuelUsage,carMillage);

        //then
        Assertions.assertTrue(result);
    }

    @Test
    public void analyzeCarByParams_carMillageNotOk_resultFalse(){

        //given
        Integer treadThickness = 3;
        Integer fuelUsage = 5;
        Integer carMillage = 210000;
        CarService service = new CarService();

        //when
        boolean result = service.analyzeCarByParams(treadThickness,fuelUsage,carMillage);

        //then
        Assertions.assertFalse(result);
    }

    @Test
    public void analyzeCarByParams_carMillageLessThanZero_throwsIllegalArgumentException(){

        //given
        Integer treadThickness = 3;
        Integer fuelUsage = 5;
        Integer carMillage = -1;
        CarService service = new CarService();

        //when

        //then
        Assertions.assertThrows(IllegalArgumentException.class,() ->  service.analyzeCarByParams(treadThickness,fuelUsage,carMillage));
    }
}
