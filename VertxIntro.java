package group.art;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
 
/*public class VertxIntro extends AbstractVerticle {
 
  @Override
  public void start(Future<Void> fut) {
 
	  // Use minimum of JRE 1.8
System.out.println("Verticle Started");	  
    vertx
        .createHttpServer()
        .requestHandler(r -> {
          r.response().end("<h1>Hello from my first " +
              "Vert.x 3 application</h1>");
        })
        .listen(8081, result -> {
          if (result.succeeded()) {
            fut.complete();
          } else {
            fut.fail(result.cause());
          }
        });
  }*/
  
  public class VertxIntro extends AbstractVerticle{
	 
	  private String name = null;

	    public VertxIntro(String name) {
	        this.name = name;
	    }

	    public void start(Future<Void> startFuture) {
	        vertx.eventBus().consumer("anAddress", message -> {
	            System.out.println(this.name + 
	                " received message: " +
	                message.body());
	        });
	    }
  }
