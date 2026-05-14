package org.example.iutprojectdocker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

@RestController
public class HelloController {

<<<<<<< HEAD
=======
    /**
     * @return Number of hits or null if Redis is unavailable
     */
>>>>>>> origin/redis-feature
    private Long getHitCountSafe() throws InterruptedException {
        int retries = 5;

        while (retries >= 0) {
            try (Jedis jedis = new Jedis("redis", 6379)) {
                return jedis.incr("hits");
            } catch (Exception e) {
                if (retries == 0) {
                    return null;
                }
                retries--;
                Thread.sleep(500);
            }
        }
        return null;
    }
<<<<<<< HEAD
=======

>>>>>>> origin/redis-feature

    @GetMapping("/")
    public String hello() {
        try {
<<<<<<< HEAD
            String appUser = System.getenv("APP_USER");
            String name = (appUser == null || appUser.isEmpty()) ? "World" : appUser;
            Long count = getHitCountSafe();
            String base = String.format("Hello %s!", name);
            
=======
            Long count = getHitCountSafe();
            String base = "Hello World";
>>>>>>> origin/redis-feature
            return (count == null)
                    ? base + " (Redis indisponible)\n"
                    : base + String.format(" J'ai été visité %d fois.\n", count);

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
