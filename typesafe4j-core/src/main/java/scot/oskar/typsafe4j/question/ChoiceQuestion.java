package scot.oskar.typsafe4j.question;

import java.util.Map;

public record ChoiceQuestion(String instructions, Map<String, String> criteria) implements Question {}
