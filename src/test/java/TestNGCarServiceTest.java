import org.testng.Assert;
import org.testng.annotations.Test;
import pl.sterniczuk.serwis.CarDetails;
import pl.sterniczuk.serwis.CarDiagnosticResult;
import pl.sterniczuk.serwis.CarService;

import java.util.ArrayList;
import java.util.List;

public class TestNGCarServiceTest {

    @Test
    public void test(){


        //given
        CarService carService = new CarService();
        List<CarDetails> carsDetails = createCarDetailsFirstCase();

        //when
        List<CarDiagnosticResult> results = carService.analyzeCars(carsDetails);

        //then
        List<CarDiagnosticResult>  expcectedResults =createExpectedResaultsFirstCase();
        Assert.assertEquals(results,expcectedResults);
    }

    @Test
    public void test2(){


        //given
        CarService carService = new CarService();
        List<CarDetails> carsDetails = createCarDetailsFalseCase();

        //when
        List<CarDiagnosticResult> results = carService.analyzeCars(carsDetails);

        //then
        List<CarDiagnosticResult>  expcectedResults = createExpectedResultsFalseCase();
        Assert.assertEquals(results,expcectedResults);
    }

    private List<CarDiagnosticResult> createExpectedResaultsFirstCase(){


        List<CarDiagnosticResult>  results = new ArrayList<>();

        results.add( new CarDiagnosticResult("1",true));
        results.add( new CarDiagnosticResult("2",false));
        results.add( new CarDiagnosticResult("3",true));

        return results;

    }

    private List<CarDiagnosticResult> createExpectedResultsFalseCase(){


        List<CarDiagnosticResult>  results = new ArrayList<>();

        results.add( new CarDiagnosticResult("1",false));
        results.add( new CarDiagnosticResult("2",false));
        results.add( new CarDiagnosticResult("3",false));
        results.add( new CarDiagnosticResult("4",false));
        results.add( new CarDiagnosticResult("5",false));
        results.add( new CarDiagnosticResult("6",false));

        return results;

    }


    private List<CarDetails> createCarDetailsFirstCase(){

        List<CarDetails> carsDetails = new ArrayList<>();

        carsDetails.add(createCarDetails("1", 3, 3, 3));
        carsDetails.add(createCarDetails("2", 3, 300000, 3));
        carsDetails.add(createCarDetails("3", 3, 3, 3));
        return carsDetails;

    }

    private List<CarDetails> createCarDetailsFalseCase(){

        List<CarDetails> carsDetails = new ArrayList<>();

        carsDetails.add(createCarDetails("1", 3, 15, 3));
        carsDetails.add(createCarDetails("2", 3, 3, 2500));
        carsDetails.add(createCarDetails("3", 3, 16, 30000));
        carsDetails.add(createCarDetails("4", 3000000, 3, 3));
        carsDetails.add(createCarDetails("5", 333333, 3333333, 3333333));
        carsDetails.add(createCarDetails("6", 3, 32, 3));
        return carsDetails;

    }


    private CarDetails createCarDetails(String id, Integer thickness, Integer fuelUsage, Integer carMillage){

        CarDetails carDetails = new CarDetails();
        carDetails.setId(id);
        carDetails.setTreadThickness(thickness);
        carDetails.setFuelUsage(fuelUsage);
        carDetails.setCarMillage(carMillage);

        return carDetails;
    }

}
