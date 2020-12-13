package Borman.cbbbluechips.builders;

import Borman.cbbbluechips.models.JumpMenuItem;

public final class JumpMenuItemBuilder {

    private JumpMenuItem jumpMenuItem;

    private JumpMenuItemBuilder() {
        jumpMenuItem = new JumpMenuItem();
    }

    public static JumpMenuItemBuilder aJumpMenuItem() {
        return new JumpMenuItemBuilder();
    }

    public JumpMenuItemBuilder withUrl(String url) {
        jumpMenuItem.setUrl(url);
        return this;
    }

    public JumpMenuItemBuilder withDisplayString(String displayString) {
        jumpMenuItem.setDisplayString(displayString);
        return this;
    }

    public JumpMenuItemBuilder withLocked(boolean locked) {
        jumpMenuItem.setLocked(locked);
        return this;
    }

    public JumpMenuItem build() {
        return jumpMenuItem;
    }

}
