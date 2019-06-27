package lt.codeacademy.cauzduotis.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminCommentRepository extends JpaRepository<AdminComment, Long> {
}
