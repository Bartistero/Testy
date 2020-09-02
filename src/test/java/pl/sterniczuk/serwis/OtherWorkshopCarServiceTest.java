package pl.sterniczuk.serwis;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.awt.image.AreaAveragingScaleFilter;
import java.rmi.MarshalledObject;
import java.util.ArrayList;
import java.util.List;

public class OtherWorkshopCarServiceTest {

    @Test
    public void analyzeOtherWorkshopCars_basicCase_success(){

        //given
        List<CarDetails> carDetails = new ArrayList<>();
        CarService carService = mockCarService();
        CarDetailsConverter carDetailsConverter = mockConverter(carDetails);
        OtherWorkshopCarService service = new OtherWorkshopCarService(carService, carDetailsConverter);


        //when
        service.analyzeOtherWorksopCars();


        //then
        Mockito.verify(carService).analyzeCars(carDetails);

    }

    private CarService mockCarService(){

        CarService carService = Mockito.mock(CarService.class);
        return  carService;
    }

    private CarDetailsConverter mockConverter(List<CarDetails> carDetailsList){

        CarDetailsConverter converter = Mockito.mock(CarDetailsConverter.class);
        Mockito.when(converter.convertAll()).thenReturn(carDetailsList);
        return converter;
    }
}
