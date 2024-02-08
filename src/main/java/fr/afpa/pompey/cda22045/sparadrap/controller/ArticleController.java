package fr.afpa.pompey.cda22045.sparadrap.controller;

import fr.afpa.pompey.cda22045.sparadrap.model.Article;
import fr.afpa.pompey.cda22045.sparadrap.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<Article> getAllArticle() {
        return articleService.getAllArticle();
    }

    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable Long id, @RequestBody Article updateArticle) {
        return articleService.updateArticle(id, updateArticle);
    }

    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody Article newArticle) {
        Article createArticle = articleService.save(newArticle);
        return ResponseEntity.ok(createArticle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable Long id) {
        boolean isRemoved = articleService.deleteArticle(id);

        if (!isRemoved) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
