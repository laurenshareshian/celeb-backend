package net.celebapp.matchmaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/dummymatches")
public class DummyMatchesController {

    private final DummyMatchesRepository matchesRepository;

    @Autowired
    public DummyMatchesController(DummyMatchesRepository matchesRepository) {
        this.matchesRepository = matchesRepository;
    }

    @GetMapping("/get-dummy-matches")
    public Iterable<DummyMatchesEntity> getMatches() {
        System.out.println("hi");
        return matchesRepository.findAll();
    }

    @DeleteMapping("/delete-match/{id}")
    void deleteMatch(@PathVariable Integer id) {
        matchesRepository.deleteById(id);
    }

    @PostMapping("/add-match")
    void addMatch(@RequestBody DummyMatchesEntity matches) {
        matchesRepository.save(matches);
    }

    @PutMapping("/update-match")
    void updateMatch(@RequestBody DummyMatchesEntity match) {
        matchesRepository.save(match);
    }
}