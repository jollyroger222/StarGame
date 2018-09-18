package ru.geekbrains.stargame.screen;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.badlogic.gdx.math.Vector2;
import ru.geekbrains.stargame.base.Base2DScreen;

public class MenuScreen extends Base2DScreen {

    SpriteBatch batch;
    Texture img;
    Texture img2;
    TextureRegion region;
    Vector2 pos;
    Vector2 pos2;

    Vector2 v;
    Vector2 v2;
    Vector2 v3;
    Vector2 xxx;

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        img = new Texture("fon.jpg");
        img2=new Texture("starship.jpg");
        region = new TextureRegion(img2,0,0,145,198);
        pos =new Vector2(1f,0f);
        pos2=new Vector2(0f,0f);
        v=new Vector2(1f,0f);
        v2=new Vector2(0f,0f);
        v3=new Vector2(0f,0f);
//        xxx=new Vector2(20,10);
//        v=new Vector2(xxx);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0.4f, 0.6f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img,0,0);
//        batch.setColor(1,1,1,1);
        batch.draw(region, pos.x, pos.y);
        batch.end();
//        System.out.println("pos=" + pos + " pos2=" + pos2);
//        if (pos==pos2) {
//            pos.add(v2);
//            System.out.println("STOPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
//        }
//        v3=v.cpy().add(v2);
//            System.out.println("STOPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
//            pos.add(v3);
    if (pos.x==pos2.x) {
        v.x=0;
        v.y=0;
    }else pos.add(v);



//    if (pos.y==pos2.y) {
////        v.x=0;
//        v.y=0;
//    }else pos.add(v);

    }

    @Override
    public void dispose() {

        batch.dispose();
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println("screenX=" + screenX + " screenY=" + (Gdx.graphics.getHeight()-screenY));
        int z=0;
        if (pos.x<=screenX   ) {
            pos2 = new Vector2(screenX, Gdx.graphics.getHeight()-screenY);
//            v=new Vector2(z+1,0);
            z=z+1;
        }else if(pos.x>screenX    ) {
            pos2 = new Vector2(screenX, Gdx.graphics.getHeight()-screenY);
//            v=new Vector2(z-1,0);
            z=z-1;
        }
        int z2=0;
        if ( pos.y<=Gdx.graphics.getHeight()-screenY  ) {
            pos2 = new Vector2(screenX, screenY);
//            v=new Vector2(z,z2+1);
            z2=z2+1;
        }else if (  pos.y>Gdx.graphics.getHeight()-screenY   ) {
            pos2 = new Vector2(screenX, screenY);
//            v=new Vector2(z,z2-1);
            z2=z2-1;

        }
        v=new Vector2(z,z2);

//        if (pos.y<=screenY ) {
//            pos2 = new Vector2(screenX, screenY);
//            v=new Vector2(0,1);
//        }
//        if(pos.y>screenY) {
//            pos2 = new Vector2(screenX, screenY);
//            v=new Vector2(0,-1);
//        }

//        v.x=screenX;
//        if (pos==pos2) {
//            v2 = new Vector2(1f,0f);
//        }
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
//        System.out.println("screenX=" + screenX + " screenY=" + (Gdx.graphics.getHeight()-screenY));

        return super.mouseMoved(screenX, screenY);
    }
}
