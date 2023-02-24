package co.develhope.StudioMedicoGruppo2Java8.repositories;

import co.develhope.StudioMedicoGruppo2Java8.entities.MedicalOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalOfficeRepository extends JpaRepository<MedicalOffice,String> {
}
