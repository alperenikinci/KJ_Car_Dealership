package com.alperen.utility;

import com.alperen.entity.*;
import com.alperen.entity.enums.*;
import com.alperen.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class DataImpl implements ApplicationRunner {
    private final ElectricEngineService electricEngineService;
    private final InternalCombustionEngineService internalCombustionEngineService;
    private final FuelCarService fuelCarService;
    private final ElectricCarService electricCarService;
    private final CountryService countryService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        createElectricEngines();
        createFuelEngines();
        createFuelCars();
        createElectricCars();
        createCountries();
    }

    public void createElectricCars() {
        List<ElectricCar> electricCars = new ArrayList<>();

// Ford Mustang Mach-E
        ElectricCar fordMustangMachE = ElectricCar.builder()
                .brand(EBrand.FORD)
                .model("Mustang Mach-E")
                .color(EColor.BLUE)
                .year(2024)
                .price(60000.0)
                .isNew(true)
                .bodyType(EBodyType.SUV)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(2200.0)
                .topSpeed(180.0)
                .electricEngineId(1L)
                .batteryCapacity(1000.0)
                .energyConsumption(18.0)
                .build();
        electricCars.add(fordMustangMachE);

// Kia Soul EV
        ElectricCar kiaSoulEV = ElectricCar.builder()
                .brand(EBrand.KIA)
                .model("Soul EV")
                .color(EColor.RED)
                .year(2024)
                .price(35000.0)
                .isNew(true)
                .bodyType(EBodyType.HATCHBACK)
                .drivetrainType(EDrivetrainType.FRONT_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1800.0)
                .topSpeed(160.0)
                .electricEngineId(2L)
                .batteryCapacity(500.0)
                .energyConsumption(16.0)
                .build();
        electricCars.add(kiaSoulEV);

// Mini Cooper SE
        ElectricCar miniCooperSE = ElectricCar.builder()
                .brand(EBrand.MINI)
                .model("Cooper SE")
                .color(EColor.WHITE)
                .year(2024)
                .price(40000.0)
                .isNew(true)
                .bodyType(EBodyType.HATCHBACK)
                .drivetrainType(EDrivetrainType.FRONT_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1700.0)
                .topSpeed(150.0)
                .electricEngineId(3L)
                .batteryCapacity(400.0)
                .energyConsumption(14.0)
                .build();
        electricCars.add(miniCooperSE);

// Polestar 2
        ElectricCar polestar2 = ElectricCar.builder()
                .brand(EBrand.POLESTAR)
                .model("2")
                .color(EColor.SILVER)
                .year(2024)
                .price(60000.0)
                .isNew(true)
                .bodyType(EBodyType.SEDAN)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(2000.0)
                .topSpeed(200.0)
                .electricEngineId(4L)
                .batteryCapacity(600.0)
                .energyConsumption(20.0)
                .build();
        electricCars.add(polestar2);

// Rivian R1T
        ElectricCar rivianR1T = ElectricCar.builder()
                .brand(EBrand.RIVIAN)
                .model("R1T")
                .color(EColor.BLACK)
                .year(2024)
                .price(75000.0)
                .isNew(true)
                .bodyType(EBodyType.PICKUP_TRUCK)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(2500.0)
                .topSpeed(180.0)
                .electricEngineId(5L)
                .batteryCapacity(800.0)
                .energyConsumption(25.0)
                .build();
        electricCars.add(rivianR1T);

// Rivian R1S
        ElectricCar rivianR1S = ElectricCar.builder()
                .brand(EBrand.RIVIAN)
                .model("R1S")
                .color(EColor.WHITE)
                .year(2024)
                .price(80000.0)
                .isNew(true)
                .bodyType(EBodyType.SUV)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(2600.0)
                .topSpeed(190.0)
                .electricEngineId(6L)
                .batteryCapacity(900.0)
                .energyConsumption(27.0)
                .build();
        electricCars.add(rivianR1S);

// Lucid Air
        ElectricCar lucidAir = ElectricCar.builder()
                .brand(EBrand.LUCID)
                .model("Air")
                .color(EColor.SILVER)
                .year(2024)
                .price(80000.0)
                .isNew(true)
                .bodyType(EBodyType.SEDAN)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(2200.0)
                .topSpeed(220.0)
                .electricEngineId(7L)
                .batteryCapacity(1000.0)
                .energyConsumption(22.0)
                .build();
        electricCars.add(lucidAir);

// GMC Hummer EV
        ElectricCar gmcHummerEV = ElectricCar.builder()
                .brand(EBrand.GMC)
                .model("Hummer EV")
                .color(EColor.BLACK)
                .year(2024)
                .price(100000.0)
                .isNew(true)
                .bodyType(EBodyType.SUV)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(3000.0)
                .topSpeed(160.0)
                .electricEngineId(8L)
                .batteryCapacity(1200.0)
                .energyConsumption(30.0)
                .build();
        electricCars.add(gmcHummerEV);

// Volkswagen ID.3
        ElectricCar volkswagenID3 = ElectricCar.builder()
                .brand(EBrand.VOLKSWAGEN)
                .model("ID.3")
                .color(EColor.BLUE)
                .year(2024)
                .price(45000.0)
                .isNew(true)
                .bodyType(EBodyType.HATCHBACK)
                .drivetrainType(EDrivetrainType.REAR_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1900.0)
                .topSpeed(170.0)
                .electricEngineId(9L)
                .batteryCapacity(700.0)
                .energyConsumption(15.0)
                .build();
        electricCars.add(volkswagenID3);

// Nissan Ariya
        ElectricCar nissanAriya = ElectricCar.builder()
                .brand(EBrand.NISSAN)
                .model("Ariya")
                .color(EColor.GRAY)
                .year(2024)
                .price(55000.0)
                .isNew(true)
                .bodyType(EBodyType.SUV)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(2200.0)
                .topSpeed(190.0)
                .electricEngineId(10L)
                .batteryCapacity(800.0)
                .energyConsumption(20.0)
                .build();
        electricCars.add(nissanAriya);

// Tesla Model S
        ElectricCar teslaModelS = ElectricCar.builder()
                .brand(EBrand.TESLA)
                .model("Model S")
                .color(EColor.RED)
                .year(2024)
                .price(80000.0)
                .isNew(true)
                .bodyType(EBodyType.SEDAN)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(2100.0)
                .topSpeed(200.0)
                .electricEngineId(11L)
                .batteryCapacity(1000.0)
                .energyConsumption(25.0)
                .build();
        electricCars.add(teslaModelS);

// Audi e-tron
        ElectricCar audiEtron = ElectricCar.builder()
                .brand(EBrand.AUDI)
                .model("e-tron")
                .color(EColor.BLACK)
                .year(2024)
                .price(90000.0)
                .isNew(true)
                .bodyType(EBodyType.SUV)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(2400.0)
                .topSpeed(210.0)
                .electricEngineId(12L)
                .batteryCapacity(900.0)
                .energyConsumption(23.0)
                .build();
        electricCars.add(audiEtron);

// Jaguar I-PACE
        ElectricCar jaguarIPace = ElectricCar.builder()
                .brand(EBrand.JAGUAR)
                .model("I-PACE")
                .color(EColor.GREEN)
                .year(2024)
                .price(95000.0)
                .isNew(true)
                .bodyType(EBodyType.SUV)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(2300.0)
                .topSpeed(200.0)
                .electricEngineId(13L)
                .batteryCapacity(1000.0)
                .energyConsumption(26.0)
                .build();
        electricCars.add(jaguarIPace);

// BMW i3
        ElectricCar bmwi3 = ElectricCar.builder()
                .brand(EBrand.BMW)
                .model("i3")
                .color(EColor.WHITE)
                .year(2024)
                .price(55000.0)
                .isNew(true)
                .bodyType(EBodyType.HATCHBACK)
                .drivetrainType(EDrivetrainType.REAR_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1800.0)
                .topSpeed(160.0)
                .electricEngineId(14L)
                .batteryCapacity(700.0)
                .energyConsumption(18.0)
                .build();
        electricCars.add(bmwi3);

// Nissan Leaf
        ElectricCar nissanLeaf = ElectricCar.builder()
                .brand(EBrand.NISSAN)
                .model("Leaf")
                .color(EColor.SILVER)
                .year(2024)
                .price(45000.0)
                .isNew(true)
                .bodyType(EBodyType.HATCHBACK)
                .drivetrainType(EDrivetrainType.FRONT_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1700.0)
                .topSpeed(150.0)
                .electricEngineId(15L)
                .batteryCapacity(600.0)
                .energyConsumption(14.0)
                .build();
        electricCars.add(nissanLeaf);

// Mercedes-Benz EQC
        ElectricCar mercedesEQC = ElectricCar.builder()
                .brand(EBrand.MERCEDES_BENZ)
                .model("EQC")
                .color(EColor.BLACK)
                .year(2024)
                .price(85000.0)
                .isNew(true)
                .bodyType(EBodyType.SUV)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(2500.0)
                .topSpeed(200.0)
                .electricEngineId(16L)
                .batteryCapacity(900.0)
                .energyConsumption(23.0)
                .build();
        electricCars.add(mercedesEQC);

// Porsche Taycan
        ElectricCar porscheTaycan = ElectricCar.builder()
                .brand(EBrand.PORSCHE)
                .model("Taycan")
                .color(EColor.RED)
                .year(2024)
                .price(100000.0)
                .isNew(true)
                .bodyType(EBodyType.SEDAN)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(2200.0)
                .topSpeed(250.0)
                .electricEngineId(17L)
                .batteryCapacity(1000.0)
                .energyConsumption(28.0)
                .build();
        electricCars.add(porscheTaycan);

// Volkswagen ID.4
        ElectricCar volkswagenID4 = ElectricCar.builder()
                .brand(EBrand.VOLKSWAGEN)
                .model("ID.4")
                .color(EColor.BLUE)
                .year(2024)
                .price(50000.0)
                .isNew(true)
                .bodyType(EBodyType.SUV)
                .drivetrainType(EDrivetrainType.REAR_WHEEL_DRIVE)
                .mileage(0L)
                .weight(2000.0)
                .topSpeed(180.0)
                .electricEngineId(18L)
                .batteryCapacity(800.0)
                .energyConsumption(20.0)
                .build();
        electricCars.add(volkswagenID4);

// Hyundai Kona Electric
        ElectricCar hyundaiKona = ElectricCar.builder()
                .brand(EBrand.HYUNDAI)
                .model("Kona Electric")
                .color(EColor.GREEN)
                .year(2024)
                .price(40000.0)
                .isNew(true)
                .bodyType(EBodyType.SUV)
                .drivetrainType(EDrivetrainType.FRONT_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1900.0)
                .topSpeed(170.0)
                .electricEngineId(19L)
                .batteryCapacity(700.0)
                .energyConsumption(17.0)
                .build();
        electricCars.add(hyundaiKona);

// Chevrolet Bolt EV
        ElectricCar chevroletBoltEV = ElectricCar.builder()
                .brand(EBrand.CHEVROLET)
                .model("Bolt EV")
                .color(EColor.RED)
                .year(2024)
                .price(35000.0)
                .isNew(true)
                .bodyType(EBodyType.HATCHBACK)
                .drivetrainType(EDrivetrainType.FRONT_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1800.0)
                .topSpeed(160.0)
                .electricEngineId(20L)
                .batteryCapacity(600.0)
                .energyConsumption(15.0)
                .build();
        electricCars.add(chevroletBoltEV);

        electricCars.stream().forEach(x -> x.setCarCode(CarCodeGenerator.generateCarCode(CarCodeGenerator.generateBatchNumber(), x)));


        electricCarService.saveAll(electricCars);

    }

    public void createHybridCars() {
        List<HybridCar> hybridCars = new ArrayList<>();

// Toyota Prius
        HybridCar toyotaPrius = HybridCar.builder()
                .brand(EBrand.TOYOTA)
                .model("Prius")
                .color(EColor.GREEN)
                .year(2024)
                .price(28000.0)
                .isNew(true)
                .bodyType(EBodyType.HATCHBACK)
                .drivetrainType(EDrivetrainType.FRONT_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1380.0)
                .topSpeed(180.0)
                .carCode("TOYOTAPRIUS123")
                .electricEngineId(123L)
                .internalCombustionEngineId(456L)
                .batteryCapacity(60.0)
                .energyConsumption(4.5)
                .singleEngineEnergyConsumption(5.5)
                .fuelCapacity(45.0)
                .fuelConsumption(5.0)
                .singleEngineFuelConsumption(6.0)
                .build();
        hybridCars.add(toyotaPrius);

// Honda Insight
        HybridCar hondaInsight = HybridCar.builder()
                .brand(EBrand.HONDA)
                .model("Insight")
                .color(EColor.BLUE)
                .year(2024)
                .price(25000.0)
                .isNew(true)
                .bodyType(EBodyType.SEDAN)
                .drivetrainType(EDrivetrainType.FRONT_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1350.0)
                .topSpeed(175.0)
                .carCode("HONDAINSIGHT456")
                .electricEngineId(456L)
                .internalCombustionEngineId(789L)
                .batteryCapacity(55.0)
                .energyConsumption(4.0)
                .singleEngineEnergyConsumption(5.0)
                .fuelCapacity(40.0)
                .fuelConsumption(4.5)
                .singleEngineFuelConsumption(5.5)
                .build();
        hybridCars.add(hondaInsight);

// Lexus ES Hybrid
        HybridCar lexusESHybrid = HybridCar.builder()
                .brand(EBrand.LEXUS)
                .model("ES Hybrid")
                .color(EColor.SILVER)
                .year(2024)
                .price(45000.0)
                .isNew(true)
                .bodyType(EBodyType.SEDAN)
                .drivetrainType(EDrivetrainType.FRONT_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1600.0)
                .topSpeed(190.0)
                .carCode("LEXUSES123")
                .electricEngineId(123L)
                .internalCombustionEngineId(234L)
                .batteryCapacity(50.0)
                .energyConsumption(5.0)
                .singleEngineEnergyConsumption(6.0)
                .fuelCapacity(45.0)
                .fuelConsumption(5.5)
                .singleEngineFuelConsumption(6.5)
                .build();
        hybridCars.add(lexusESHybrid);

// Ford Escape Hybrid
        HybridCar fordEscapeHybrid = HybridCar.builder()
                .brand(EBrand.FORD)
                .model("Escape Hybrid")
                .color(EColor.WHITE)
                .year(2024)
                .price(32000.0)
                .isNew(true)
                .bodyType(EBodyType.SUV)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1550.0)
                .topSpeed(170.0)
                .carCode("FORDESCAPE789")
                .electricEngineId(789L)
                .internalCombustionEngineId(890L)
                .batteryCapacity(45.0)
                .energyConsumption(4.5)
                .singleEngineEnergyConsumption(5.5)
                .fuelCapacity(50.0)
                .fuelConsumption(5.0)
                .singleEngineFuelConsumption(6.0)
                .build();
        hybridCars.add(fordEscapeHybrid);

// Chevrolet Malibu Hybrid
        HybridCar chevroletMalibuHybrid = HybridCar.builder()
                .brand(EBrand.CHEVROLET)
                .model("Malibu Hybrid")
                .color(EColor.RED)
                .year(2024)
                .price(30000.0)
                .isNew(true)
                .bodyType(EBodyType.SEDAN)
                .drivetrainType(EDrivetrainType.FRONT_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1480.0)
                .topSpeed(175.0)
                .carCode("CHEVYMALIBU101")
                .electricEngineId(101L)
                .internalCombustionEngineId(202L)
                .batteryCapacity(40.0)
                .energyConsumption(4.0)
                .singleEngineEnergyConsumption(5.0)
                .fuelCapacity(45.0)
                .fuelConsumption(4.5)
                .singleEngineFuelConsumption(5.5)
                .build();
        hybridCars.add(chevroletMalibuHybrid);

// BMW X3 xDrive30e
        HybridCar bmwX3Hybrid = HybridCar.builder()
                .brand(EBrand.BMW)
                .model("X3 xDrive30e")
                .color(EColor.BLACK)
                .year(2024)
                .price(48000.0)
                .isNew(true)
                .bodyType(EBodyType.SUV)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1800.0)
                .topSpeed(190.0)
                .carCode("BMWX3HYBRID2022")
                .electricEngineId(2022L)
                .internalCombustionEngineId(3030L)
                .batteryCapacity(40.0)
                .energyConsumption(4.2)
                .singleEngineEnergyConsumption(5.2)
                .fuelCapacity(50.0)
                .fuelConsumption(5.0)
                .singleEngineFuelConsumption(6.0)
                .build();
        hybridCars.add(bmwX3Hybrid);

// Mercedes-Benz E-Class E 300 e
        HybridCar mercedesEClassHybrid = HybridCar.builder()
                .brand(EBrand.MERCEDES_BENZ)
                .model("E-Class E 300 e")
                .color(EColor.WHITE)
                .year(2024)
                .price(55000.0)
                .isNew(true)
                .bodyType(EBodyType.SEDAN)
                .drivetrainType(EDrivetrainType.REAR_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1850.0)
                .topSpeed(250.0)
                .carCode("MERE300E789")
                .electricEngineId(789L)
                .internalCombustionEngineId(890L)
                .batteryCapacity(45.0)
                .energyConsumption(4.5)
                .singleEngineEnergyConsumption(5.5)
                .fuelCapacity(50.0)
                .fuelConsumption(5.0)
                .singleEngineFuelConsumption(6.0)
                .build();
        hybridCars.add(mercedesEClassHybrid);

// Audi Q5 55 TFSI e quattro
        HybridCar audiQ5Hybrid = HybridCar.builder()
                .brand(EBrand.AUDI)
                .model("Q5 55 TFSI e quattro")
                .color(EColor.BLUE)
                .year(2024)
                .price(52000.0)
                .isNew(true)
                .bodyType(EBodyType.SUV)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1900.0)
                .topSpeed(230.0)
                .carCode("AUDIQ5555")
                .electricEngineId(555L)
                .internalCombustionEngineId(666L)
                .batteryCapacity(50.0)
                .energyConsumption(4.7)
                .singleEngineEnergyConsumption(5.7)
                .fuelCapacity(55.0)
                .fuelConsumption(5.5)
                .singleEngineFuelConsumption(6.5)
                .build();
        hybridCars.add(audiQ5Hybrid);

// Chevrolet Equinox Hybrid
        HybridCar chevroletEquinoxHybrid = HybridCar.builder()
                .brand(EBrand.CHEVROLET)
                .model("Equinox Hybrid")
                .color(EColor.BLACK)
                .year(2024)
                .price(35000.0)
                .isNew(true)
                .bodyType(EBodyType.SUV)
                .drivetrainType(EDrivetrainType.FRONT_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1600.0)
                .topSpeed(180.0)
                .carCode("CHEVYEQX2019")
                .electricEngineId(2019L)
                .internalCombustionEngineId(2020L)
                .batteryCapacity(40.0)
                .energyConsumption(4.3)
                .singleEngineEnergyConsumption(5.3)
                .fuelCapacity(45.0)
                .fuelConsumption(5.0)
                .singleEngineFuelConsumption(6.0)
                .build();
        hybridCars.add(chevroletEquinoxHybrid);

// Toyota Highlander Hybrid
        HybridCar toyotaHighlanderHybrid = HybridCar.builder()
                .brand(EBrand.TOYOTA)
                .model("Highlander Hybrid")
                .color(EColor.SILVER)
                .year(2024)
                .price(42000.0)
                .isNew(true)
                .bodyType(EBodyType.SUV)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1850.0)
                .topSpeed(180.0)
                .carCode("TOYOTAHIGH789")
                .electricEngineId(789L)
                .internalCombustionEngineId(890L)
                .batteryCapacity(45.0)
                .energyConsumption(4.5)
                .singleEngineEnergyConsumption(5.5)
                .fuelCapacity(50.0)
                .fuelConsumption(5.0)
                .singleEngineFuelConsumption(6.0)
                .build();
        hybridCars.add(toyotaHighlanderHybrid);

// Honda CR-V Hybrid
        HybridCar hondaCRVHybrid = HybridCar.builder()
                .brand(EBrand.HONDA)
                .model("CR-V Hybrid")
                .color(EColor.BLUE)
                .year(2024)
                .price(38000.0)
                .isNew(true)
                .bodyType(EBodyType.SUV)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1700.0)
                .topSpeed(175.0)
                .carCode("HONDACRV444")
                .electricEngineId(444L)
                .internalCombustionEngineId(555L)
                .batteryCapacity(40.0)
                .energyConsumption(4.2)
                .singleEngineEnergyConsumption(5.2)
                .fuelCapacity(50.0)
                .fuelConsumption(5.0)
                .singleEngineFuelConsumption(6.0)
                .build();
        hybridCars.add(hondaCRVHybrid);

// BMW 3 Series 330e
        HybridCar bmw3SeriesHybrid = HybridCar.builder()
                .brand(EBrand.BMW)
                .model("3 Series 330e")
                .color(EColor.WHITE)
                .year(2024)
                .price(50000.0)
                .isNew(true)
                .bodyType(EBodyType.SEDAN)
                .drivetrainType(EDrivetrainType.REAR_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1650.0)
                .topSpeed(200.0)
                .carCode("BMW330E2018")
                .electricEngineId(2018L)
                .internalCombustionEngineId(2019L)
                .batteryCapacity(45.0)
                .energyConsumption(4.3)
                .singleEngineEnergyConsumption(5.3)
                .fuelCapacity(50.0)
                .fuelConsumption(5.0)
                .singleEngineFuelConsumption(6.0)
                .build();
        hybridCars.add(bmw3SeriesHybrid);

// Lexus RX Hybrid
        HybridCar lexusRXHybrid = HybridCar.builder()
                .brand(EBrand.LEXUS)
                .model("RX Hybrid")
                .color(EColor.BLACK)
                .year(2024)
                .price(52000.0)
                .isNew(true)
                .bodyType(EBodyType.SUV)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1800.0)
                .topSpeed(185.0)
                .carCode("LEXUSRX777")
                .electricEngineId(777L)
                .internalCombustionEngineId(888L)
                .batteryCapacity(50.0)
                .energyConsumption(4.5)
                .singleEngineEnergyConsumption(5.5)
                .fuelCapacity(55.0)
                .fuelConsumption(5.5)
                .singleEngineFuelConsumption(6.5)
                .build();
        hybridCars.add(lexusRXHybrid);

// Audi A6 55 TFSI e quattro
        HybridCar audiA6Hybrid = HybridCar.builder()
                .brand(EBrand.AUDI)
                .model("A6 55 TFSI e quattro")
                .color(EColor.GRAY)
                .year(2024)
                .price(58000.0)
                .isNew(true)
                .bodyType(EBodyType.SEDAN)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1750.0)
                .topSpeed(240.0)
                .carCode("AUDIA6555")
                .electricEngineId(555L)
                .internalCombustionEngineId(666L)
                .batteryCapacity(50.0)
                .energyConsumption(4.7)
                .singleEngineEnergyConsumption(5.7)
                .fuelCapacity(55.0)
                .fuelConsumption(5.5)
                .singleEngineFuelConsumption(6.5)
                .build();
        hybridCars.add(audiA6Hybrid);

// Mercedes-Benz GLC 300 e
        HybridCar mercedesGLCHybrid = HybridCar.builder()
                .brand(EBrand.MERCEDES_BENZ)
                .model("GLC 300 e")
                .color(EColor.SILVER)
                .year(2024)
                .price(53000.0)
                .isNew(true)
                .bodyType(EBodyType.SUV)
                .drivetrainType(EDrivetrainType.REAR_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1700.0)
                .topSpeed(230.0)
                .carCode("MERCEGLC300")
                .electricEngineId(333L)
                .internalCombustionEngineId(444L)
                .batteryCapacity(45.0)
                .energyConsumption(4.5)
                .singleEngineEnergyConsumption(5.5)
                .fuelCapacity(50.0)
                .fuelConsumption(5.0)
                .singleEngineFuelConsumption(6.0)
                .build();
        hybridCars.add(mercedesGLCHybrid);

// Ford Fusion Hybrid
        HybridCar fordFusionHybrid = HybridCar.builder()
                .brand(EBrand.FORD)
                .model("Fusion Hybrid")
                .color(EColor.BLUE)
                .year(2024)
                .price(30000.0)
                .isNew(true)
                .bodyType(EBodyType.SEDAN)
                .drivetrainType(EDrivetrainType.FRONT_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1500.0)
                .topSpeed(175.0)
                .carCode("FORDFUSION777")
                .electricEngineId(777L)
                .internalCombustionEngineId(888L)
                .batteryCapacity(40.0)
                .energyConsumption(4.2)
                .singleEngineEnergyConsumption(5.2)
                .fuelCapacity(45.0)
                .fuelConsumption(4.8)
                .singleEngineFuelConsumption(5.8)
                .build();
        hybridCars.add(fordFusionHybrid);

// Chevrolet Tahoe Hybrid
        HybridCar chevroletTahoeHybrid = HybridCar.builder()
                .brand(EBrand.CHEVROLET)
                .model("Tahoe Hybrid")
                .color(EColor.BLACK)
                .year(2024)
                .price(60000.0)
                .isNew(true)
                .bodyType(EBodyType.SUV)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(2200.0)
                .topSpeed(185.0)
                .carCode("CHEVYTAHOE567")
                .electricEngineId(567L)
                .internalCombustionEngineId(678L)
                .batteryCapacity(60.0)
                .energyConsumption(5.0)
                .singleEngineEnergyConsumption(6.0)
                .fuelCapacity(70.0)
                .fuelConsumption(7.0)
                .singleEngineFuelConsumption(8.0)
                .build();
        hybridCars.add(chevroletTahoeHybrid);

// Honda Accord Hybrid
        HybridCar hondaAccordHybrid = HybridCar.builder()
                .brand(EBrand.HONDA)
                .model("Accord Hybrid")
                .color(EColor.RED)
                .year(2024)
                .price(35000.0)
                .isNew(true)
                .bodyType(EBodyType.SEDAN)
                .drivetrainType(EDrivetrainType.FRONT_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1550.0)
                .topSpeed(180.0)
                .carCode("HONDAACC789")
                .electricEngineId(789L)
                .internalCombustionEngineId(890L)
                .batteryCapacity(45.0)
                .energyConsumption(4.3)
                .singleEngineEnergyConsumption(5.3)
                .fuelCapacity(50.0)
                .fuelConsumption(5.0)
                .singleEngineFuelConsumption(6.0)
                .build();
        hybridCars.add(hondaAccordHybrid);

// Lexus NX Hybrid
        HybridCar lexusNXHybrid = HybridCar.builder()
                .brand(EBrand.LEXUS)
                .model("NX Hybrid")
                .color(EColor.SILVER)
                .year(2024)
                .price(45000.0)
                .isNew(true)
                .bodyType(EBodyType.SUV)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1700.0)
                .topSpeed(185.0)
                .carCode("LEXUSNX321")
                .electricEngineId(321L)
                .internalCombustionEngineId(432L)
                .batteryCapacity(45.0)
                .energyConsumption(4.5)
                .singleEngineEnergyConsumption(5.5)
                .fuelCapacity(50.0)
                .fuelConsumption(5.0)
                .singleEngineFuelConsumption(6.0)
                .build();
        hybridCars.add(lexusNXHybrid);

// Audi Q7 60 TFSI e quattro
        HybridCar audiQ7Hybrid = HybridCar.builder()
                .brand(EBrand.AUDI)
                .model("Q7 60 TFSI e quattro")
                .color(EColor.WHITE)
                .year(2024)
                .price(65000.0)
                .isNew(true)
                .bodyType(EBodyType.SUV)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(2300.0)
                .topSpeed(250.0)
                .carCode("AUDIQ760")
                .electricEngineId(760L)
                .internalCombustionEngineId(870L)
                .batteryCapacity(55.0)
                .energyConsumption(5.2)
                .singleEngineEnergyConsumption(6.2)
                .fuelCapacity(60.0)
                .fuelConsumption(6.0)
                .singleEngineFuelConsumption(7.0)
                .build();
        hybridCars.add(audiQ7Hybrid);

// Mercedes-Benz GLE 350 de 4MATIC
        HybridCar mercedesGLEHybrid = HybridCar.builder()
                .brand(EBrand.MERCEDES_BENZ)
                .model("GLE 350 de 4MATIC")
                .color(EColor.BLACK)
                .year(2024)
                .price(68000.0)
                .isNew(true)
                .bodyType(EBodyType.SUV)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(2400.0)
                .topSpeed(230.0)
                .carCode("MERCEGLE350")
                .electricEngineId(950L)
                .internalCombustionEngineId(1050L)
                .batteryCapacity(60.0)
                .energyConsumption(5.5)
                .singleEngineEnergyConsumption(6.5)
                .fuelCapacity(65.0)
                .fuelConsumption(6.5)
                .singleEngineFuelConsumption(7.5)
                .build();
        hybridCars.add(mercedesGLEHybrid);


    }

    public void createFuelCars() {
        List<FuelCar> fuelCarList = new ArrayList<>();
        // Ford Mustang
        FuelCar fordMustang = FuelCar.builder()
                .brand(EBrand.FORD)
                .model("Mustang")
                .color(EColor.BLUE)
                .year(2024)
                .price(45000.0)
                .isNew(true)
                .bodyType(EBodyType.COUPE)
                .drivetrainType(EDrivetrainType.REAR_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1700.0)
                .topSpeed(250.0)
                .internalCombustionEngineId(1L)
                .fuelCapacity(65.0)
                .fuelConsumption(9.0)
                .build();
        fuelCarList.add(fordMustang);

// BMW 3 Serisi
        FuelCar bmw3Series = FuelCar.builder()
                .brand(EBrand.BMW)
                .model("3 Serisi")
                .color(EColor.WHITE)
                .year(2024)
                .price(48000.0)
                .isNew(true)
                .bodyType(EBodyType.SEDAN)
                .drivetrainType(EDrivetrainType.REAR_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1600.0)
                .topSpeed(260.0)
                .internalCombustionEngineId(2L)
                .fuelCapacity(60.0)
                .fuelConsumption(8.5)
                .build();
        fuelCarList.add(bmw3Series);

// Mercedes-Benz E-Serisi
        FuelCar mercedesESerisi = FuelCar.builder()
                .brand(EBrand.MERCEDES_BENZ)
                .model("E-Serisi")
                .color(EColor.BLACK)
                .year(2024)
                .price(55000.0)
                .isNew(true)
                .bodyType(EBodyType.SEDAN)
                .drivetrainType(EDrivetrainType.REAR_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1700.0)
                .topSpeed(255.0)
                .internalCombustionEngineId(3L)
                .fuelCapacity(65.0)
                .fuelConsumption(9.0)
                .build();

        fuelCarList.add(mercedesESerisi);

        // Audi A3
        FuelCar audiA3 = FuelCar.builder()
                .brand(EBrand.AUDI)
                .model("A3")
                .color(EColor.BLACK)
                .year(2024)
                .price(35000.0)
                .isNew(true)
                .bodyType(EBodyType.HATCHBACK)
                .drivetrainType(EDrivetrainType.FRONT_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1500.0)
                .topSpeed(240.0)
                .internalCombustionEngineId(4L)
                .fuelCapacity(55.0)
                .fuelConsumption(7.5)
                .build();
        fuelCarList.add(audiA3);

// Subaru Outback
        FuelCar subaruOutback = FuelCar.builder()
                .brand(EBrand.SUBARU)
                .model("Outback")
                .color(EColor.GREEN)
                .year(2024)
                .price(40000.0)
                .isNew(true)
                .bodyType(EBodyType.WAGON)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1700.0)
                .topSpeed(230.0)
                .internalCombustionEngineId(5L)
                .fuelCapacity(60.0)
                .fuelConsumption(8.5)
                .build();
        fuelCarList.add(subaruOutback);

// Porsche Cayenne
        FuelCar porscheCayenne = FuelCar.builder()
                .brand(EBrand.PORSCHE)
                .model("Cayenne")
                .color(EColor.RED)
                .year(2024)
                .price(75000.0)
                .isNew(true)
                .bodyType(EBodyType.SUV)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(2100.0)
                .topSpeed(265.0)
                .internalCombustionEngineId(6L)
                .fuelCapacity(80.0)
                .fuelConsumption(11.0)
                .build();
        fuelCarList.add(porscheCayenne);

// Toyota Camry
        FuelCar toyotaCamry = FuelCar.builder()
                .brand(EBrand.TOYOTA)
                .model("Camry")
                .color(EColor.WHITE)
                .year(2024)
                .price(38000.0)
                .isNew(true)
                .bodyType(EBodyType.SEDAN)
                .drivetrainType(EDrivetrainType.FRONT_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1550.0)
                .topSpeed(240.0)
                .internalCombustionEngineId(7L)
                .fuelCapacity(60.0)
                .fuelConsumption(8.0)
                .build();
        fuelCarList.add(toyotaCamry);

// Honda Civic
        FuelCar hondaCivic = FuelCar.builder()
                .brand(EBrand.HONDA)
                .model("Civic")
                .color(EColor.BLUE)
                .year(2024)
                .price(32000.0)
                .isNew(true)
                .bodyType(EBodyType.SEDAN)
                .drivetrainType(EDrivetrainType.FRONT_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1450.0)
                .topSpeed(230.0)
                .internalCombustionEngineId(8L)
                .fuelCapacity(55.0)
                .fuelConsumption(7.5)
                .build();
        fuelCarList.add(hondaCivic);

// Volkswagen Golf
        FuelCar volkswagenGolf = FuelCar.builder()
                .brand(EBrand.VOLKSWAGEN)
                .model("Golf")
                .color(EColor.SILVER)
                .year(2024)
                .price(33000.0)
                .isNew(true)
                .bodyType(EBodyType.HATCHBACK)
                .drivetrainType(EDrivetrainType.FRONT_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1500.0)
                .topSpeed(240.0)
                .internalCombustionEngineId(9L)
                .fuelCapacity(55.0)
                .fuelConsumption(7.0)
                .build();
        fuelCarList.add(volkswagenGolf);

// Chevrolet Corvette
        FuelCar chevroletCorvette = FuelCar.builder()
                .brand(EBrand.CHEVROLET)
                .model("Corvette")
                .color(EColor.RED)
                .year(2024)
                .price(65000.0)
                .isNew(true)
                .bodyType(EBodyType.COUPE)
                .drivetrainType(EDrivetrainType.REAR_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1600.0)
                .topSpeed(290.0)
                .internalCombustionEngineId(10L)
                .fuelCapacity(70.0)
                .fuelConsumption(10.0)
                .build();
        fuelCarList.add(chevroletCorvette);

// Nissan GT-R
        FuelCar nissanGTR = FuelCar.builder()
                .brand(EBrand.NISSAN)
                .model("GT-R")
                .color(EColor.BLACK)
                .year(2024)
                .price(100000.0)
                .isNew(true)
                .bodyType(EBodyType.COUPE)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1800.0)
                .topSpeed(320.0)
                .internalCombustionEngineId(11L)
                .fuelCapacity(75.0)
                .fuelConsumption(12.0)
                .build();
        fuelCarList.add(nissanGTR);

// Ferrari 488 GTB
        FuelCar ferrari488GTB = FuelCar.builder()
                .brand(EBrand.FERRARI)
                .model("488 GTB")
                .color(EColor.RED)
                .year(2024)
                .price(300000.0)
                .isNew(true)
                .bodyType(EBodyType.COUPE)
                .drivetrainType(EDrivetrainType.REAR_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1550.0)
                .topSpeed(330.0)
                .internalCombustionEngineId(12L)
                .fuelCapacity(70.0)
                .fuelConsumption(15.0)
                .build();
        fuelCarList.add(ferrari488GTB);
        // Lamborghini Aventador
        FuelCar lamborghiniAventador = FuelCar.builder()
                .brand(EBrand.LAMBORGHINI)
                .model("Aventador")
                .color(EColor.YELLOW)
                .year(2024)
                .price(400000.0)
                .isNew(true)
                .bodyType(EBodyType.COUPE)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1750.0)
                .topSpeed(350.0)
                .internalCombustionEngineId(13L)
                .fuelCapacity(75.0)
                .fuelConsumption(18.0)
                .build();
        fuelCarList.add(lamborghiniAventador);

// McLaren 720S
        FuelCar mclaren720S = FuelCar.builder()
                .brand(EBrand.MCLAREN)
                .model("720S")
                .color(EColor.ORANGE)
                .year(2024)
                .price(350000.0)
                .isNew(true)
                .bodyType(EBodyType.COUPE)
                .drivetrainType(EDrivetrainType.REAR_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1450.0)
                .topSpeed(340.0)
                .internalCombustionEngineId(14L)
                .fuelCapacity(65.0)
                .fuelConsumption(16.0)
                .build();
        fuelCarList.add(mclaren720S);

// Bugatti Chiron
        FuelCar bugattiChiron = FuelCar.builder()
                .brand(EBrand.BUGATTI)
                .model("Chiron")
                .color(EColor.BLACK)
                .year(2024)
                .price(3000000.0)
                .isNew(true)
                .bodyType(EBodyType.COUPE)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1950.0)
                .topSpeed(420.0)
                .internalCombustionEngineId(15L)
                .fuelCapacity(100.0)
                .fuelConsumption(25.0)
                .build();
        fuelCarList.add(bugattiChiron);

// Aston Martin Vantage
        FuelCar astonMartinVantage = FuelCar.builder()
                .brand(EBrand.ASTON_MARTIN)
                .model("Vantage")
                .color(EColor.BLUE)
                .year(2024)
                .price(180000.0)
                .isNew(true)
                .bodyType(EBodyType.COUPE)
                .drivetrainType(EDrivetrainType.REAR_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1550.0)
                .topSpeed(330.0)
                .internalCombustionEngineId(16L)
                .fuelCapacity(65.0)
                .fuelConsumption(14.0)
                .build();
        fuelCarList.add(astonMartinVantage);

// Rolls-Royce Ghost
        FuelCar rollsRoyceGhost = FuelCar.builder()
                .brand(EBrand.ROLLS_ROYCE)
                .model("Ghost")
                .color(EColor.WHITE)
                .year(2024)
                .price(400000.0)
                .isNew(true)
                .bodyType(EBodyType.SEDAN)
                .drivetrainType(EDrivetrainType.REAR_WHEEL_DRIVE)
                .mileage(0L)
                .weight(2500.0)
                .topSpeed(250.0)
                .internalCombustionEngineId(17L)
                .fuelCapacity(90.0)
                .fuelConsumption(20.0)
                .build();
        fuelCarList.add(rollsRoyceGhost);

// Bentley Continental GT
        FuelCar bentleyContinentalGT = FuelCar.builder()
                .brand(EBrand.BENTLEY)
                .model("Continental GT")
                .color(EColor.SILVER)
                .year(2024)
                .price(350000.0)
                .isNew(true)
                .bodyType(EBodyType.COUPE)
                .drivetrainType(EDrivetrainType.ALL_WHEEL_DRIVE)
                .mileage(0L)
                .weight(2300.0)
                .topSpeed(320.0)
                .internalCombustionEngineId(18L)
                .fuelCapacity(85.0)
                .fuelConsumption(22.0)
                .build();
        fuelCarList.add(bentleyContinentalGT);

// Maserati Quattroporte
        FuelCar maseratiQuattroporte = FuelCar.builder()
                .brand(EBrand.MASERATI)
                .model("Quattroporte")
                .color(EColor.BLACK)
                .year(2024)
                .price(250000.0)
                .isNew(true)
                .bodyType(EBodyType.SEDAN)
                .drivetrainType(EDrivetrainType.REAR_WHEEL_DRIVE)
                .mileage(0L)
                .weight(2000.0)
                .topSpeed(290.0)
                .internalCombustionEngineId(19L)
                .fuelCapacity(80.0)
                .fuelConsumption(18.0)
                .build();
        fuelCarList.add(maseratiQuattroporte);

// Alfa Romeo Giulia
        FuelCar alfaRomeoGiulia = FuelCar.builder()
                .brand(EBrand.ALFA_ROMEO)
                .model("Giulia")
                .color(EColor.RED)
                .year(2024)
                .price(60000.0)
                .isNew(true)
                .bodyType(EBodyType.SEDAN)
                .drivetrainType(EDrivetrainType.REAR_WHEEL_DRIVE)
                .mileage(0L)
                .weight(1600.0)
                .topSpeed(280.0)
                .internalCombustionEngineId(20L)
                .fuelCapacity(65.0)
                .fuelConsumption(12.0)
                .build();
        fuelCarList.add(alfaRomeoGiulia);

        fuelCarList.stream().forEach(x -> x.setCarCode(CarCodeGenerator.generateCarCode(CarCodeGenerator.generateBatchNumber(), x)));
        fuelCarService.saveAll(fuelCarList);

    }

    public void createElectricEngines() {
        List<ElectricEngine> electricEngines = new ArrayList<>();

// Ford Mustang Mach-E Electric Engine
        ElectricEngine fordMustangMachEEngine = ElectricEngine.builder()
                .id(1L)
                .name("Ford Mustang Mach-E Electric Engine")
                .horsePower(480L)
                .torque(860.0)
                .fuelType(EFuelType.ELECTRIC)
                .chargingTime(480)
                .brand(EBrand.FORD)
                .build();
        electricEngines.add(fordMustangMachEEngine);

// Kia Soul EV Electric Engine
        ElectricEngine kiaSoulEVEngine = ElectricEngine.builder()
                .id(2L)
                .name("Kia Soul EV Electric Engine")
                .horsePower(201L)
                .torque(395.0)
                .fuelType(EFuelType.ELECTRIC)
                .chargingTime(540)
                .brand(EBrand.KIA)
                .build();
        electricEngines.add(kiaSoulEVEngine);

// Mini Cooper SE Electric Engine
        ElectricEngine miniCooperSEEngine = ElectricEngine.builder()
                .id(3L)
                .name("Mini Cooper SE Electric Engine")
                .horsePower(181L)
                .torque(270.0)
                .fuelType(EFuelType.ELECTRIC)
                .chargingTime(420)
                .brand(EBrand.MINI)
                .build();
        electricEngines.add(miniCooperSEEngine);

// Polestar 2 Electric Engine
        ElectricEngine polestar2Engine = ElectricEngine.builder()
                .id(4L)
                .name("Polestar 2 Electric Engine")
                .horsePower(408L)
                .torque(660.0)
                .fuelType(EFuelType.ELECTRIC)
                .chargingTime(480)
                .brand(EBrand.POLESTAR)
                .build();
        electricEngines.add(polestar2Engine);

// Rivian R1T Electric Engine
        ElectricEngine rivianR1TEngine = ElectricEngine.builder()
                .id(5L)
                .name("Rivian R1T Electric Engine")
                .horsePower(700L)
                .torque(829.0)
                .fuelType(EFuelType.ELECTRIC)
                .chargingTime(600)
                .brand(EBrand.RIVIAN)
                .build();
        electricEngines.add(rivianR1TEngine);

// Rivian R1S Electric Engine
        ElectricEngine rivianR1SEngine = ElectricEngine.builder()
                .id(6L)
                .name("Rivian R1S Electric Engine")
                .horsePower(700L)
                .torque(826.0)
                .fuelType(EFuelType.ELECTRIC)
                .chargingTime(600)
                .brand(EBrand.RIVIAN)
                .build();
        electricEngines.add(rivianR1SEngine);

// Lucid Air Electric Engine
        ElectricEngine lucidAirEngine = ElectricEngine.builder()
                .id(7L)
                .name("Lucid Air Electric Engine")
                .horsePower(1080L)
                .torque(980.0)
                .fuelType(EFuelType.ELECTRIC)
                .chargingTime(540)
                .brand(EBrand.LUCID)
                .build();
        electricEngines.add(lucidAirEngine);

// GMC Hummer EV Electric Engine
        ElectricEngine gmcHummerEVEngine = ElectricEngine.builder()
                .id(8L)
                .name("GMC Hummer EV Electric Engine")
                .horsePower(1000L)
                .torque(1550.0)
                .fuelType(EFuelType.ELECTRIC)
                .chargingTime(720)
                .brand(EBrand.GMC)
                .build();
        electricEngines.add(gmcHummerEVEngine);

// Volkswagen ID.3 Electric Engine
        ElectricEngine volkswagenID3Engine = ElectricEngine.builder()
                .id(9L)
                .name("Volkswagen ID.3 Electric Engine")
                .horsePower(201L)
                .torque(310.0)
                .fuelType(EFuelType.ELECTRIC)
                .chargingTime(480)
                .brand(EBrand.VOLKSWAGEN)
                .build();
        electricEngines.add(volkswagenID3Engine);

// Nissan Ariya Electric Engine
        ElectricEngine nissanAriyaEngine = ElectricEngine.builder()
                .id(10L)
                .name("Nissan Ariya Electric Engine")
                .horsePower(389L)
                .torque(600.0)
                .fuelType(EFuelType.ELECTRIC)
                .chargingTime(540)
                .brand(EBrand.NISSAN)
                .build();
        electricEngines.add(nissanAriyaEngine);

// Tesla Model S Electric Engine
        ElectricEngine teslaModelSEngine = ElectricEngine.builder()
                .id(11L)
                .name("Tesla Model S Electric Engine")
                .horsePower(700L)
                .torque(900.0)
                .fuelType(EFuelType.ELECTRIC)
                .chargingTime(480)
                .brand(EBrand.TESLA)
                .build();
        electricEngines.add(teslaModelSEngine);

// Audi e-tron Electric Engine
        ElectricEngine audiEtronEngine = ElectricEngine.builder()
                .id(12L)
                .name("Audi e-tron Electric Engine")
                .horsePower(500L)
                .torque(800.0)
                .fuelType(EFuelType.ELECTRIC)
                .chargingTime(600)
                .brand(EBrand.AUDI)
                .build();
        electricEngines.add(audiEtronEngine);

// Jaguar I-PACE Electric Engine
        ElectricEngine jaguarIPaceEngine = ElectricEngine.builder()
                .id(13L)
                .name("Jaguar I-PACE Electric Engine")
                .horsePower(600L)
                .torque(850.0)
                .fuelType(EFuelType.ELECTRIC)
                .chargingTime(540)
                .brand(EBrand.JAGUAR)
                .build();
        electricEngines.add(jaguarIPaceEngine);

// BMW i3 Electric Engine
        ElectricEngine bmwi3Engine = ElectricEngine.builder()
                .id(14L)
                .name("BMW i3 Electric Engine")
                .horsePower(170L)
                .torque(250.0)
                .fuelType(EFuelType.ELECTRIC)
                .chargingTime(360)
                .brand(EBrand.BMW)
                .build();
        electricEngines.add(bmwi3Engine);

// Nissan Leaf Electric Engine
        ElectricEngine nissanLeafEngine = ElectricEngine.builder()
                .id(15L)
                .name("Nissan Leaf Electric Engine")
                .horsePower(150L)
                .torque(320.0)
                .fuelType(EFuelType.ELECTRIC)
                .chargingTime(420)
                .brand(EBrand.NISSAN)
                .build();
        electricEngines.add(nissanLeafEngine);

// Mercedes-Benz EQC Electric Engine
        ElectricEngine mercedesEQCEngine = ElectricEngine.builder()
                .id(16L)
                .name("Mercedes-Benz EQC Electric Engine")
                .horsePower(408L)
                .torque(760.0)
                .fuelType(EFuelType.ELECTRIC)
                .chargingTime(660)
                .brand(EBrand.MERCEDES_BENZ)
                .build();
        electricEngines.add(mercedesEQCEngine);

// Porsche Taycan Electric Engine
        ElectricEngine porscheTaycanEngine = ElectricEngine.builder()
                .id(17L)
                .name("Porsche Taycan Electric Engine")
                .horsePower(625L)
                .torque(850.0)
                .fuelType(EFuelType.ELECTRIC)
                .chargingTime(540)
                .brand(EBrand.PORSCHE)
                .build();
        electricEngines.add(porscheTaycanEngine);

// Volkswagen ID.4 Electric Engine
        ElectricEngine volkswagenID4Engine = ElectricEngine.builder()
                .id(18L)
                .name("Volkswagen ID.4 Electric Engine")
                .horsePower(201L)
                .torque(310.0)
                .fuelType(EFuelType.ELECTRIC)
                .chargingTime(480)
                .brand(EBrand.VOLKSWAGEN)
                .build();
        electricEngines.add(volkswagenID4Engine);

// Hyundai Kona Electric Engine
        ElectricEngine hyundaiKonaEngine = ElectricEngine.builder()
                .id(19L)
                .name("Hyundai Kona Electric Engine")
                .horsePower(201L)
                .torque(395.0)
                .fuelType(EFuelType.ELECTRIC)
                .chargingTime(540)
                .brand(EBrand.HYUNDAI)
                .build();
        electricEngines.add(hyundaiKonaEngine);

// Chevrolet Bolt EV Electric Engine
        ElectricEngine chevroletBoltEngine = ElectricEngine.builder()
                .id(20L)
                .name("Chevrolet Bolt EV Electric Engine")
                .horsePower(200L)
                .torque(360.0)
                .fuelType(EFuelType.ELECTRIC)
                .chargingTime(540)
                .brand(EBrand.CHEVROLET)
                .build();
        electricEngines.add(chevroletBoltEngine);
        electricEngineService.saveAll(electricEngines);
    }

    public void createFuelEngines() {
        List<InternalCombustionEngine> engineList = new ArrayList<>();
        // Ford EcoBoost Motor
        InternalCombustionEngine fordEcoboostEngine = InternalCombustionEngine.builder()
                .id(1L)
                .name("Ford EcoBoost")
                .horsePower(310L)
                .torque(350.0)
                .fuelType(EFuelType.GASOLINE)
                .engineVolume(2.3)
                .cylinders(ECylinders.CYLINDER_FOUR)
                .turboCount(1)
                .brand(EBrand.FORD)
                .build();

// BMW B58 Motor
        InternalCombustionEngine bmwB58Engine = InternalCombustionEngine.builder()
                .id(2L)
                .name("BMW B58")
                .horsePower(382L)
                .torque(369.0)
                .fuelType(EFuelType.GASOLINE)
                .engineVolume(3.0)
                .cylinders(ECylinders.CYLINDER_SIX)
                .turboCount(1)
                .brand(EBrand.BMW)
                .build();

// Mercedes-Benz M256 Motor
        InternalCombustionEngine mercedesM256Engine = InternalCombustionEngine.builder()
                .id(3L)
                .name("Mercedes-Benz M256")
                .horsePower(362L)
                .torque(369.0)
                .fuelType(EFuelType.GASOLINE)
                .engineVolume(3.0)
                .cylinders(ECylinders.CYLINDER_SIX)
                .turboCount(1)
                .brand(EBrand.MERCEDES_BENZ)
                .build();

// Audi EA888 Motor
        InternalCombustionEngine audiEA888Engine = InternalCombustionEngine.builder()
                .id(4L)
                .name("Audi EA888")
                .horsePower(306L)
                .torque(295.0)
                .fuelType(EFuelType.GASOLINE)
                .engineVolume(2.0)
                .cylinders(ECylinders.CYLINDER_FOUR)
                .turboCount(1)
                .brand(EBrand.AUDI)
                .build();

// Subaru EJ25 Motor
        InternalCombustionEngine subaruEJ25Engine = InternalCombustionEngine.builder()
                .id(5L)
                .name("Subaru EJ25")
                .horsePower(310L)
                .torque(290.0)
                .fuelType(EFuelType.GASOLINE)
                .engineVolume(2.5)
                .cylinders(ECylinders.CYLINDER_FOUR)
                .turboCount(0)
                .brand(EBrand.SUBARU)
                .build();

// Porsche 9A2 Motor
        InternalCombustionEngine porsche9A2Engine = InternalCombustionEngine.builder()
                .id(6L)
                .name("Porsche 9A2")
                .horsePower(385L)
                .torque(440.0)
                .fuelType(EFuelType.GASOLINE)
                .engineVolume(3.0)
                .cylinders(ECylinders.CYLINDER_SIX)
                .turboCount(1)
                .brand(EBrand.PORSCHE)
                .build();

// Toyota 2JZ Motor
        InternalCombustionEngine toyota2JZEngine = InternalCombustionEngine.builder()
                .id(7L)
                .name("Toyota 2JZ")
                .horsePower(320L)
                .torque(325.0)
                .fuelType(EFuelType.GASOLINE)
                .engineVolume(3.0)
                .cylinders(ECylinders.CYLINDER_SIX)
                .turboCount(1)
                .brand(EBrand.TOYOTA)
                .build();

// Honda K20C Motor
        InternalCombustionEngine hondaK20CEngine = InternalCombustionEngine.builder()
                .id(8L)
                .name("Honda K20C")
                .horsePower(306L)
                .torque(295.0)
                .fuelType(EFuelType.GASOLINE)
                .engineVolume(2.0)
                .cylinders(ECylinders.CYLINDER_FOUR)
                .turboCount(1)
                .brand(EBrand.HONDA)
                .build();

// Volkswagen EA888 Motor
        InternalCombustionEngine volkswagenEA888Engine = InternalCombustionEngine.builder()
                .id(9L)
                .name("Volkswagen EA888")
                .horsePower(315L)
                .torque(310.0)
                .fuelType(EFuelType.GASOLINE)
                .engineVolume(2.0)
                .cylinders(ECylinders.CYLINDER_FOUR)
                .turboCount(1)
                .brand(EBrand.VOLKSWAGEN)
                .build();

// Chevrolet LT1 Motor
        InternalCombustionEngine chevroletLT1Engine = InternalCombustionEngine.builder()
                .id(10L)
                .name("Chevrolet LT1")
                .horsePower(455L)
                .torque(455.0)
                .fuelType(EFuelType.GASOLINE)
                .engineVolume(6.2)
                .cylinders(ECylinders.CYLINDER_EIGHT)
                .turboCount(0)
                .brand(EBrand.CHEVROLET)
                .build();

// Nissan VR38DETT Motor
        InternalCombustionEngine nissanVR38DETTEngine = InternalCombustionEngine.builder()
                .id(11L)
                .name("Nissan VR38DETT")
                .horsePower(600L)
                .torque(481.0)
                .fuelType(EFuelType.GASOLINE)
                .engineVolume(3.8)
                .cylinders(ECylinders.CYLINDER_SIX)
                .turboCount(2)
                .brand(EBrand.NISSAN)
                .build();

// Ferrari F154 Motor
        InternalCombustionEngine ferrariF154Engine = InternalCombustionEngine.builder()
                .id(12L)
                .name("Ferrari F154")
                .horsePower(710L)
                .torque(568.0)
                .fuelType(EFuelType.GASOLINE)
                .engineVolume(3.9)
                .cylinders(ECylinders.CYLINDER_EIGHT)
                .turboCount(2)
                .brand(EBrand.FERRARI)
                .build();

// Lamborghini V12 Motor
        InternalCombustionEngine lamborghiniV12Engine = InternalCombustionEngine.builder()
                .id(13L)
                .name("Lamborghini V12")
                .horsePower(785L)
                .torque(531.0)
                .fuelType(EFuelType.GASOLINE)
                .engineVolume(6.5)
                .cylinders(ECylinders.CYLINDER_TWELVE)
                .turboCount(0)
                .brand(EBrand.LAMBORGHINI)
                .build();

// McLaren M840T Motor
        InternalCombustionEngine mclarenM840TEngine = InternalCombustionEngine.builder()
                .id(14L)
                .name("McLaren M840T")
                .horsePower(720L)
                .torque(568.0)
                .fuelType(EFuelType.GASOLINE)
                .engineVolume(4.0)
                .cylinders(ECylinders.CYLINDER_EIGHT)
                .turboCount(2)
                .brand(EBrand.MCLAREN)
                .build();

// Bugatti W16 Motor
        InternalCombustionEngine bugattiW16Engine = InternalCombustionEngine.builder()
                .id(15L)
                .name("Bugatti W16")
                .horsePower(1500L)
                .torque(1600.0)
                .fuelType(EFuelType.GASOLINE)
                .engineVolume(8.0)
                .cylinders(ECylinders.CYLINDER_SIXTEEN)
                .turboCount(4)
                .brand(EBrand.BUGATTI)
                .build();

// Aston Martin AMG V8 Motor
        InternalCombustionEngine astonMartinAMGV8Engine = InternalCombustionEngine.builder()
                .id(16L)
                .name("Aston Martin AMG V8")
                .horsePower(503L)
                .torque(505.0)
                .fuelType(EFuelType.GASOLINE)
                .engineVolume(4.0)
                .cylinders(ECylinders.CYLINDER_EIGHT)
                .turboCount(2)
                .brand(EBrand.ASTON_MARTIN)
                .build();

// Rolls-Royce V12 Motor
        InternalCombustionEngine rollsRoyceV12Engine = InternalCombustionEngine.builder()
                .id(17L)
                .name("Rolls-Royce V12")
                .horsePower(563L)
                .torque(627.0)
                .fuelType(EFuelType.GASOLINE)
                .engineVolume(6.8)
                .cylinders(ECylinders.CYLINDER_TWELVE)
                .turboCount(0)
                .brand(EBrand.ROLLS_ROYCE)
                .build();

// Bentley W12 Motor
        InternalCombustionEngine bentleyW12Engine = InternalCombustionEngine.builder()
                .id(18L)
                .name("Bentley W12")
                .horsePower(626L)
                .torque(664.0)
                .fuelType(EFuelType.GASOLINE)
                .engineVolume(6.0)
                .cylinders(ECylinders.CYLINDER_TWELVE)
                .turboCount(0)
                .brand(EBrand.BENTLEY)
                .build();

// Maserati Nettuno V6 Motor
        InternalCombustionEngine maseratiNettunoV6Engine = InternalCombustionEngine.builder()
                .id(19L)
                .name("Maserati Nettuno V6")
                .horsePower(621L)
                .torque(538.0)
                .fuelType(EFuelType.GASOLINE)
                .engineVolume(3.0)
                .cylinders(ECylinders.CYLINDER_SIX)
                .turboCount(2)
                .brand(EBrand.MASERATI)
                .build();

// Alfa Romeo V6 Motor
        InternalCombustionEngine alfaRomeoV6Engine = InternalCombustionEngine.builder()
                .id(20L)
                .name("Alfa Romeo V6")
                .horsePower(505L)
                .torque(443.0)
                .fuelType(EFuelType.GASOLINE)
                .engineVolume(2.9)
                .cylinders(ECylinders.CYLINDER_SIX)
                .turboCount(2)
                .brand(EBrand.ALFA_ROMEO)
                .build();

        engineList.addAll(List.of(fordEcoboostEngine, bmwB58Engine, mercedesM256Engine, audiEA888Engine, subaruEJ25Engine, porsche9A2Engine, toyota2JZEngine, hondaK20CEngine, volkswagenEA888Engine, chevroletLT1Engine, nissanVR38DETTEngine, ferrariF154Engine, lamborghiniV12Engine, mclarenM840TEngine, bugattiW16Engine, astonMartinAMGV8Engine, rollsRoyceV12Engine, bentleyW12Engine, maseratiNettunoV6Engine, alfaRomeoV6Engine));
        internalCombustionEngineService.saveAll(engineList);
    }

    //TODO HYBRID ENGINE YAPILACAK.
    public  void createCountries() {
        List<Country> europeanCountries = new ArrayList<>();

        europeanCountries.add(Country.builder()
                .name("Germany")
                .isoCode("DE")
                .capital("Berlin")
                .continent("Europe")
                .region("Western Europe")
                .build());

        europeanCountries.add(Country.builder()
                .name("France")
                .isoCode("FR")
                .capital("Paris")
                .continent("Europe")
                .region("Western Europe")
                .build());

        europeanCountries.add(Country.builder()
                .name("United Kingdom")
                .isoCode("GB")
                .capital("London")
                .continent("Europe")
                .region("Northern Europe")
                .build());

        europeanCountries.add(Country.builder()
                .name("Italy")
                .isoCode("IT")
                .capital("Rome")
                .continent("Europe")
                .region("Southern Europe")
                .build());

        europeanCountries.add(Country.builder()
                .name("Spain")
                .isoCode("ES")
                .capital("Madrid")
                .continent("Europe")
                .region("Southern Europe")
                .build());

        List<Country> secondaryEuropeanCountries = new ArrayList<>();

        secondaryEuropeanCountries.add(Country.builder()
                .name("Greece")
                .isoCode("GR")
                .capital("Athens")
                .continent("Europe")
                .region("Southern Europe")
                .build());

        secondaryEuropeanCountries.add(Country.builder()
                .name("Poland")
                .isoCode("PL")
                .capital("Warsaw")
                .continent("Europe")
                .region("Eastern Europe")
                .build());

        secondaryEuropeanCountries.add(Country.builder()
                .name("Sweden")
                .isoCode("SE")
                .capital("Stockholm")
                .continent("Europe")
                .region("Northern Europe")
                .build());

        secondaryEuropeanCountries.add(Country.builder()
                .name("Portugal")
                .isoCode("PT")
                .capital("Lisbon")
                .continent("Europe")
                .region("Southern Europe")
                .build());

        secondaryEuropeanCountries.add(Country.builder()
                .name("Netherlands")
                .isoCode("NL")
                .capital("Amsterdam")
                .continent("Europe")
                .region("Western Europe")
                .build());

        secondaryEuropeanCountries.add(Country.builder()
                .name("Belgium")
                .isoCode("BE")
                .capital("Brussels")
                .continent("Europe")
                .region("Western Europe")
                .build());

        secondaryEuropeanCountries.add(Country.builder()
                .name("Switzerland")
                .isoCode("CH")
                .capital("Bern")
                .continent("Europe")
                .region("Central Europe")
                .build());

        secondaryEuropeanCountries.add(Country.builder()
                .name("Austria")
                .isoCode("AT")
                .capital("Vienna")
                .continent("Europe")
                .region("Central Europe")
                .build());

        secondaryEuropeanCountries.add(Country.builder()
                .name("Czech Republic")
                .isoCode("CZ")
                .capital("Prague")
                .continent("Europe")
                .region("Eastern Europe")
                .build());

        secondaryEuropeanCountries.add(Country.builder()
                .name("Hungary")
                .isoCode("HU")
                .capital("Budapest")
                .continent("Europe")
                .region("Eastern Europe")
                .build());

        secondaryEuropeanCountries.add(Country.builder()
                .name("Turkey")
                .isoCode("TR")
                .capital("Ankara")
                .continent("Asia")
                .region("Middle East")
                .build());


        // Diğer ikincil Avrupa ülkeleri buraya eklenebilir

        countryService.saveAll(secondaryEuropeanCountries);
        countryService.saveAll(europeanCountries);
    }
}




