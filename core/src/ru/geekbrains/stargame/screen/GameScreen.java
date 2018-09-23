package ru.geekbrains.stargame.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.stargame.base.Base2DScreen;
import ru.geekbrains.stargame.base.Sprite;
import ru.geekbrains.stargame.math.Rect;
import ru.geekbrains.stargame.sprites.Background;
import ru.geekbrains.stargame.sprites.Ship;
import ru.geekbrains.stargame.sprites.Star;

public class GameScreen extends Base2DScreen {

    private static final int STAR_COUNT = 64;

    Background background;
    Sprite sprite;
    Ship ship;
    Texture bg;
    TextureAtlas atlas;

    Texture img2;
    TextureRegion region;
    Vector2 pos;


    Vector2 v;
    Vector2 buf;

    Star[] star;

    public GameScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        bg = new Texture("fon.jpg");
        background = new Background(new TextureRegion(bg));
        atlas = new TextureAtlas("textures/mainAtlas.tpack");
        star = new Star[STAR_COUNT];
        for (int i = 0; i < star.length; i++) {
            star[i] = new Star(atlas);
        }

        //Тесты
        img2=new Texture("starship.jpg");
        pos =new Vector2(0f,0f);
        region = new TextureRegion(img2,0,0,145,198);
        ship=  new Ship(new TextureRegion(img2));
        ship.setHeightProportion(0.5f);
        //img2=new Texture("starship.jpg");
        //region = new TextureRegion(img2,0,0,145,198);

        v=new Vector2(0f,0f);
        buf=new Vector2(0f,0f);


    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
//        checkCollisions();
//        deleteAllDestroyed();
        draw();

    }

    public void update(float delta) {
        for (int i = 0; i < star.length; i++) {
            star[i].update(delta);
        }
    }

    public void checkCollisions() {

    }

    public void deleteAllDestroyed() {

    }

    public void draw() {
        Gdx.gl.glClearColor(1, 0.4f, 0.6f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        buf.set(touch);
        batch.begin();
        background.draw(batch);
        for (int i = 0; i < star.length; i++) {
            star[i].draw(batch);
        }
        if(buf.sub(pos).len()>0.5f){
            pos.add(v);
        }else {
            pos.set(touch);
        }
        //batch.begin();
//        sprite.draw(batch);
//        batch.draw(region, pos.x, pos.y);
        //batch.end();
        ship.draw(batch);
        batch.end();
    }

    @Override
    protected void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (int i = 0; i < star.length; i++) {
            star[i].resize(worldBounds);
        }
    }

    @Override
    public void dispose() {
        bg.dispose();
        atlas.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        touch.set(touch.cpy().sub(pos).setLength(0.5f));

        return super.touchDown(screenX, screenY, pointer, button);
    }
}
