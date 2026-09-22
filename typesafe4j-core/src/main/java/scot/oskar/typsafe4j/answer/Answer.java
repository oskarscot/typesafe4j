package scot.oskar.typsafe4j.answer;

public sealed interface Answer permits ChoiceAnswer, NoulAnswer, ScoreAnswer { }
