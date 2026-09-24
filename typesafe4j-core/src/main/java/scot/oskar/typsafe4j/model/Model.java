package scot.oskar.typsafe4j.model;

/// Known model aliases for System One requests.
public enum Model {

    /// The `jev-latest` model alias.
    JEV_LATEST("jev-latest"),
    /// The `jev-preview` model alias.
    JEV_PREVIEW("jev-preview");

    private final String modelAlias;

    Model(String modelAlias) {
        this.modelAlias = modelAlias;
    }

    /// Returns the model alias sent to the API.
    ///
    /// @return the model alias
    public String getModelAlias() {
        return modelAlias;
    }
}
