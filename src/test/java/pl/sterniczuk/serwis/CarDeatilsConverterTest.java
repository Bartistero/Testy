package pl.sterniczuk.serwis;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;
import other.OtherWorkShopCarDetailsService;
import other.OtherWorkshopCarDetailsDTO;
import pl.sterniczuk.serwis.CarDetails;

import javax.print.attribute.standard.MediaSize;
import java.util.Arrays;
import java.util.List;


public class CarDeatilsConverterTest {

    private CarDetailsConverter toTest;


    @Test
    public void convertAll_simpleCase_convertSuccess() {

        //given
        OtherWorkShopCarDetailsService service = createServiceMock();
        toTest = new CarDetailsConverter(service);

        //when

        List<CarDetails> result =   toTest.convertAll();

        //then
        Assert.assertEquals(result.size(), 2);
    }

    private OtherWorkShopCarDetailsService createServiceMock(){

        OtherWorkShopCarDetailsService service = Mockito.mock(OtherWorkShopCarDetailsService.class);
        List<OtherWorkshopCarDetailsDTO> content = dbContent();
        Mockito.when(service.findCarDetailsToAnalyze()).thenReturn(content);

        return service;
    }

    private List<OtherWorkshopCarDetailsDTO> dbContent(){
        return Arrays.asList(createMock(1,3,5,10000),
                createMock(2,2,10,15000));
    }



    @Test
    public void convert_simpleCase_convertSuccess(){

        //given

        toTest = new CarDetailsConverter(null);
        OtherWorkshopCarDetailsDTO itemToTest = createMock(1,10,6,3);

        //when
        CarDetails carDetails = toTest.convert(itemToTest);

        //then
        Assert.assertEquals(carDetails.getId(), "1");
        Assert.assertEquals(carDetails.getCarMillage(), Integer.valueOf(3));
        Assert.assertEquals(carDetails.getFuelUsage(), Integer.valueOf(6));
        Assert.assertEquals(carDetails.getTreadThickness(), Integer.valueOf(10));

    }
    private OtherWorkshopCarDetailsDTO createMock(Integer id, Integer treadThickness, Integer fuelUsage, Integer carMillage){

        OtherWorkshopCarDetailsDTO mock = Mockito.mock(OtherWorkshopCarDetailsDTO.class);

        Mockito.when(mock.getId()).thenReturn(id);
        Mockito.when(mock.getCarMillage()).thenReturn(carMillage);
        Mockito.when(mock.getFuelUsage()).thenReturn(fuelUsage);
        Mockito.when(mock.getThreadThickness()).thenReturn(treadThickness);

        return mock;
    }
}
