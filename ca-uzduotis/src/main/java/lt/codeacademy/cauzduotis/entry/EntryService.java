package lt.codeacademy.cauzduotis.entry;

import lt.codeacademy.cauzduotis.utils.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntryService {

    private final EntryRepository entryRepository;

    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public List<EntryView> getEntries() {
        return entryRepository.findAll().stream()
                .map(this::mapToView)
                .collect(Collectors.toList());
    }

    public EntryView addEntry(EntryView entryView) {
        return mapToView(entryRepository.save(mapFromEntry(entryView)));
    }

    public HttpStatus deleteEntry(long id) {
        entryRepository.delete(findEntryById(id));
        return HttpStatus.OK;
    }

    private Entry mapFromEntry(EntryView entryView) {
        return new Entry(entryView.getHeadline(), entryView.getHeadlineText(), entryView.getEntrySaveDate(), entryView.getEntryText(), entryView.getCommentList(), entryView.getAuthorName());
    }


    private EntryView mapToView(Entry entry) {
        return new EntryView(entry.getId(), entry.getHeadline(), entry.getEntrySaveDate(), entry.getEntryText(), entry.getCommentList(), entry.getAuthorName());
    }

    public EntryView editEntry(EntryView entryView, long id) {
        Entry entry = findEntryById(id);
        if (entryView.getAuthorName() != null) {
            entry.setAuthorName(entryView.getAuthorName());
        }
        if (entryView.getEntryText() != null) {
            entry.setEntryText(entryView.getEntryText());
        }
        if (entryView.getEntrySaveDate() != null) {
            entry.setEntrySaveDate(entryView.getEntrySaveDate());
        }
        if (entryView.getHeadlineText() != null) {
            entry.setHeadlineText(entryView.getHeadlineText());
        }
        if (entryView.getHeadline() != null) {
            entry.setHeadline(entryView.getHeadline());
        }
        if (entryView.getCommentList() != null) {
            entry.setCommentList(entryView.getCommentList());
        }

        return mapToView(entryRepository.save(entry));
    }

    private Entry findEntryById(long id) {
        return entryRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }
}
