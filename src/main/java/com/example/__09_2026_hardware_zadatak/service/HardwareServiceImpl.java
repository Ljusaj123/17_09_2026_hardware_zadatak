package com.example.__09_2026_hardware_zadatak.service;

import com.example.__09_2026_hardware_zadatak.domain.Hardware;
import com.example.__09_2026_hardware_zadatak.domain.Type;
import com.example.__09_2026_hardware_zadatak.dto.HardwareDTO;
import com.example.__09_2026_hardware_zadatak.repository.HardwareRepository;
import com.example.__09_2026_hardware_zadatak.repository.SpringDataHardwareRepository;
import com.example.__09_2026_hardware_zadatak.repository.SpringDataTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HardwareServiceImpl implements HardwareService {

    //    private HardwareRepository hardwareRepository;
    private SpringDataTypeRepository springDataTypeRepository;
    private SpringDataHardwareRepository springDataHardwareRepository;

    @Override
    public List<HardwareDTO> getAllHardware() {
//        return hardwareRepository.getAllHardware().stream().map(HardwareDTO::new).toList();

        return springDataHardwareRepository.findAll().stream()
                .map(HardwareDTO::new)
                .toList();
    }

    @Override
    public HardwareDTO getHardwareByCode(String hardwareCode) {
//        Hardware hardware = hardwareRepository.getHardwareByCode(hardwareCode)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hardware ne postoji"));
//        return new HardwareDTO(hardware);


        Hardware hardware = springDataHardwareRepository.findBySifra(hardwareCode);
        return new HardwareDTO(hardware);
    }

    @Override
    public void saveNewHardware(HardwareDTO hardwareDTO) {
        //        hardwareRepository.saveNewHardware(hardware);

        Hardware hardware = convertHardwareDtoToHardware(hardwareDTO);
        springDataHardwareRepository.save(hardware);


    }

    @Override
    public void updateHardware(HardwareDTO hardwareDTO, Integer hardwareId) {

//        Hardware hardware = new Hardware(hardwareDTO);
//
//        Optional<Hardware> updatedHardware =
//                hardwareRepository.updateHardware(hardware, hardwareId);
//
//        if (updatedHardware.isEmpty()) {
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND,
//                    "Hardware sa ID-em " + hardwareId + " ne postoji"
//            );
//        }


        Optional<Hardware> hardwareToUpdate = springDataHardwareRepository.findById(hardwareId);

        if (hardwareToUpdate.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Hardware sa ID-em " + hardwareId + " ne postoji"
            );
        }


        Hardware hardware = hardwareToUpdate.get();
        hardware.setCijena(hardwareDTO.getCijena());
        hardware.setNaziv(hardwareDTO.getNaziv());
        hardware.setKolicina(hardwareDTO.getKolicina());
        hardware.setSifra(hardwareDTO.getSifra());

        Type type = springDataTypeRepository.findByNaziv(hardwareDTO.getNaziv());

        hardware.setTip(type);

        springDataHardwareRepository.save(hardware);
    }

    @Override
    public void deleteHardwareById(Integer hardwareId) {

        Optional<Hardware> hardware = springDataHardwareRepository.findById(hardwareId);

        if (hardware.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Hardware sa ID-em " + hardwareId + " ne postoji"
            );
        }

        springDataHardwareRepository.deleteById(hardwareId);

//        boolean deleted = hardwareRepository.deleteHardware(hardwareId);

//        if (!deleted) {
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND,
//                    "Hardware sa ID-em " + hardwareId + " ne postoji"
//            );
//        }
    }

//    private HardwareDTO convertHardwareToHardwareDTO(Hardware hardware) {
//        return new HardwareDTO(hardware.getNaziv(),
//                hardware.getSifra(), hardware.getCijena(),
//                hardware.getTip().getNaziv(),
//                hardware.getKolicina());
//    }

    private Hardware convertHardwareDtoToHardware(HardwareDTO hardwareDTO) {
        Hardware hardware = new Hardware();

        hardware.setNaziv(hardwareDTO.getNaziv());
        hardware.setSifra(hardwareDTO.getSifra());
        hardware.setCijena(hardwareDTO.getCijena());
        hardware.setKolicina(hardwareDTO.getKolicina());
        hardware.setTip(
                springDataTypeRepository.findByNaziv(hardwareDTO.getTip())
        );

        return hardware;

    }
}