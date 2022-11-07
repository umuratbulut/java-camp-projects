package kodlamaio.devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.devs.entities.concretes.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {

}
