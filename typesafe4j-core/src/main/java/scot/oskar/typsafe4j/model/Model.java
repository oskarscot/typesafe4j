package scot.oskar.typsafe4j.model;

public enum Model {

    JEV_LATEST("jev-latest"),
    JEV_PREVIEW("jev-preview");

    private final String modelAlias;

    Model(String modelAlias) {
        this.modelAlias = modelAlias;
    }

    public String getModelAlias() {
        return modelAlias;
    }
}
