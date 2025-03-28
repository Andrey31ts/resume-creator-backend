package resume.creator.backend.top.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import resume.creator.backend.top.models.Answer;
import resume.creator.backend.top.models.ResumeQuestion;
import resume.creator.backend.top.models.ResumeType;
import resume.creator.logic.models.Resume;
import resume.creator.logic.services.ResumeService;

@RestController
@RequestMapping("resume")
public class ResumeController {
    @GetMapping
    public ResponseEntity<List<ResumeType>> GetResumeTypes() {
        // Get List objects from service
        // Test data
        List<ResumeType> resumeTypes = new ArrayList<ResumeType>();

        resumeTypes.add(new ResumeType("DefaultResume"));
        resumeTypes.add(new ResumeType("TopResume"));

        return ResponseEntity.ok(resumeTypes);
    }

    @GetMapping("list")
    public ResponseEntity<List<Resume>> GetResumeTypes(int userId) {
        ResumeService resumeService = new ResumeService();

        List<Resume> createdResume = resumeService.GetListResume(userId);

        return ResponseEntity.ok(createdResume);
    }

    @GetMapping("questions")
    public ResponseEntity<List<ResumeQuestion>> GetResumeQuestions(String resumeName) {
        // Get List objects from service
        // Test data
        List<ResumeQuestion> resumeTypes = new ArrayList<ResumeQuestion>();

        resumeTypes.add(new ResumeQuestion("Сколько вам лет?", "int"));
        resumeTypes.add(new ResumeQuestion("Какой ваш стаж?", "int"));

        return ResponseEntity.ok(resumeTypes);
    }

    @PostMapping("answers")
    public ResponseEntity<String> GetResumeQuestions(@RequestBody List<Answer> answers) {
        // Get List objects from service
        // Test data
        if(answers.size() > 0){
            return new ResponseEntity<String>("success", HttpStatus.CREATED);
        }

        return new ResponseEntity<String>("error", HttpStatus.CREATED);
    }
}
