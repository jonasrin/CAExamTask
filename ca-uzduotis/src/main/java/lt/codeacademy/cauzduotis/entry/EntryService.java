package lt.codeacademy.cauzduotis.entry;

import lt.codeacademy.cauzduotis.comment.Comment;
import lt.codeacademy.cauzduotis.comment.CommentView;
import lt.codeacademy.cauzduotis.utils.NotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntryService {
    Logger logger = LoggerFactory.getLogger(EntryService.class);
    private final EntryRepository entryRepository;

    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public List<EntryView> getEntries() {
        List<EntryView> entryViewList = entryRepository.findAll().stream()
                .map(this::mapToView)
                .collect(Collectors.toList());
        logger.info("Got entries count: " + entryViewList.size());
        return entryViewList;
    }

    public EntryView addEntry(EntryView entryView) {
        entryView.setEntrySaveDate(LocalDate.now());
        EntryView view = mapToView(entryRepository.save(mapFromEntry(entryView)));
        logger.info("Entry was added" + entryView.toString());
        return view;
    }

    public HttpStatus deleteEntry(long id) {
        entryRepository.delete(findEntryById(id));
        return HttpStatus.OK;
    }

    private Entry mapFromEntry(EntryView entryView) {
        return new Entry(entryView.getHeadline(), entryView.getHeadlineText(), entryView.getEntrySaveDate(), entryView.getEntryText(), Collections.EMPTY_LIST, entryView.getAuthorName());
    }


    private EntryView mapToView(Entry entry) {
        List<CommentView> commentViews = entry.getCommentList().stream()
                .map(this::mapToCommentView)
                .collect(Collectors.toList());
        return new EntryView(entry.getId(), entry.getHeadline(), entry.getEntrySaveDate(), entry.getEntryText(), commentViews, entry.getAuthorName());
    }

    private CommentView mapToCommentView(Comment comment) {
        return new CommentView(comment.getId(), comment.getAuthorName(), comment.getCommentText(), comment.getCommentSaveDate(), comment.getAdminComment());
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

        return mapToView(entryRepository.save(entry));
    }

    private Entry findEntryById(long id) {
        return entryRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }
}
