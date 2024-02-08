package fr.afpa.pompey.cda22045.sparadrap.repository;

import fr.afpa.pompey.cda22045.sparadrap.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
