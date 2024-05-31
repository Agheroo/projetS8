package org.univamu.polytech.backend.embeddables;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class GridPlayerId implements Serializable {

    private Integer grid;

    private String player;

    public Integer getGrid() {
        return grid;
    }

    public void setGrid(Integer grid) {
        this.grid = grid;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((grid == null) ? 0 : grid.hashCode());
        result = prime * result + ((player == null) ? 0 : player.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GridPlayerId other = (GridPlayerId) obj;
        if (grid == null) {
            if (other.grid != null)
                return false;
        } else if (!grid.equals(other.grid))
            return false;
        if (player == null) {
            if (other.player != null)
                return false;
        } else if (!player.equals(other.player))
            return false;
        return true;
    }
}
