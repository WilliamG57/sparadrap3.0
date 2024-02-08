package fr.afpa.pompey.cda22045.sparadrap.service;

import fr.afpa.pompey.cda22045.sparadrap.model.Article;
import fr.afpa.pompey.cda22045.sparadrap.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public ArticleService(){}

    public Article save(Article article) {
        return articleRepository.save(article);
    }

    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    public List<Article> getAllArticle() {
        return articleRepository.findAll();
    }

    public Article updateArticle(Long id, Article updateArticle) {
        if (articleRepository.existsById(id)) {
            updateArticle.setArt_id(id);
            return articleRepository.save(updateArticle);
        } else {
            // Gérer le cas où l'article n'existe pas
            return null;
        }
    }

    public boolean deleteArticle(Long id) {
        if (articleRepository.existsById(id)) {
            articleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
