package lt.codeacademy.cauzduotis.entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/entry")
public class EntryController {
    private final EntryService entryService;

    @Autowired
    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping(path = "/get-entries")
    public List<EntryView> getEntries(){
        return entryService.getEntries();
    }

    @PostMapping(path = "/create-entry")
    public EntryView addEntry(@RequestBody EntryView entryView){
        return entryService.addEntry(entryView);
    }

    @DeleteMapping(path = "/delete-entry/{id}")
    public HttpStatus deleteEntry(@PathVariable(name = "id") long id){
        return entryService.deleteEntry(id);
    }

    @PutMapping (path = "/edit-entry/{id}")
    public EntryView editEntry(@RequestBody EntryView entryView, @PathVariable(name = "id") long id){
        return entryService.editEntry(entryView, id);
    }


}
