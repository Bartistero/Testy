package pl.sterniczuk.serwis;

import other.OtherWorkShopCarDetailsService;
import other.OtherWorkshopCarDetailsDTO;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CarDetailsConverter {

    private final OtherWorkShopCarDetailsService otherWorkShopCarDetailsService;


    public CarDetailsConverter(OtherWorkShopCarDetailsService otherWorkShopCarDetailsService) {
        this.otherWorkShopCarDetailsService = otherWorkShopCarDetailsService;
    }

    public List<CarDetails> convertAll(){

        List<OtherWorkshopCarDetailsDTO> toConvert = otherWorkShopCarDetailsService.findCarDetailsToAnalyze();
        return toConvert.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    CarDetails convert(OtherWorkshopCarDetailsDTO dto){

        CarDetails details = new CarDetails();

        details.setId(String.valueOf(dto.getId()));
        details.setCarMillage(dto.getCarMillage());
        details.setFuelUsage(dto.getFuelUsage());
        details.setTreadThickness(dto.getThreadThickness());

        return details;
    }
}
