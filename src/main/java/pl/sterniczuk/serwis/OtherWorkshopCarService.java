package pl.sterniczuk.serwis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import other.OtherWorkShopCarDetailsService;

import javax.management.ConstructorParameters;
import java.util.List;

@AllArgsConstructor
public class OtherWorkshopCarService {

    private CarService carService;

    private CarDetailsConverter converter;

    public List<CarDiagnosticResult> analyzeOtherWorksopCars(){

        List<CarDetails> toAnalyze = converter.convertAll();
        return carService.analyzeCars(toAnalyze);
    }
}

