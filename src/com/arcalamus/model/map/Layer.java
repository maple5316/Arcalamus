package com.arcalamus.model.map;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.arcalamus.render.Component;

public class Layer implements Iterator<Tile>, Component {

	private final List<Tile> tiles = new LinkedList<Tile>();

	public Tile getTile(int index) {
		return tiles.get(index);
	}

	public Tile getTileAt(Position position) {
		for (Tile tile : tiles) {
			if (position.equals(tile.getPosition())) {
				return tile;
			}
		}
		return null;
	}

	public List<Tile> getTilesOfType(Tile.Type type) {
		List<Tile> tiles = new ArrayList<Tile>();
		for (Tile tile : this.tiles) {
			if (type.equals(tile.getType())) {
				tiles.add(tile);
			}
		}
		return tiles;
	}

	public boolean isTileOfType(int index, Tile.Type type) {
		return type.equals(getTile(index).getType());
	}

	@Override
	public boolean hasNext() {
		return tiles.iterator().hasNext();
	}

	@Override
	public Tile next() {
		return tiles.iterator().next();
	}

	@Override
	public void remove() {
		tiles.iterator().remove();
	}

	@Override
	public void render(Graphics g) {

	}

	public static enum Type {
		TERRAIN,
		FRINGE,
		OBJECTS;

		public static Type forIndex(int index) {
			return values()[index];
		}
	}

}