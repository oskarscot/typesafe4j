package scot.oskar.typsafe4j.question;

import java.util.List;

public record ScoreQuestion(String instructions, List<String> criteria) implements Question { }
