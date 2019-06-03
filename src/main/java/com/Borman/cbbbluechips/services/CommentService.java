package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.builders.CommentBuilder;
import com.Borman.cbbbluechips.models.Comment;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class CommentService {


    public List<Comment> getComments() {
        List<Comment> comments = new ArrayList<>();
        IntStream.range(0, 2).mapToObj(x -> getFixtureComment()).forEach(comment -> {
            List<Comment> subComments = Arrays.asList(getFixtureComment(), getFixtureComment(), getFixtureComment());
            comment.setSubComments(subComments);
            comments.add(comment);
        });
        return comments;
    }

    private Comment getFixtureComment() {
        return CommentBuilder.aComment()
                .withTimeOfComment(LocalDateTime.now())
                .withCommentValue("This is a test comment. This is only a test")
                .withAuthor("Test Author")
                .build();
    }

}
