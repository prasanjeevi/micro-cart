package com.cloudnative.frontend;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    @GetMapping("/api/demo")
    public String ping() {
        return "Pong";
    }

    @GetMapping("/api/demo/status/ok")
    public void ok() {
    }

    @GetMapping("/api/demo/status/created")
    @ResponseStatus(HttpStatus.CREATED)
    public void created() {
    }

    @GetMapping("/api/demo/status/nocontent")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void noContent() {
    }

    @GetMapping("/api/demo/status/badrequest")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void badRequest() {
    }

    @GetMapping("/api/demo/status/unauthorized")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void unathorized() {
    }

    @GetMapping("/api/demo/status/forbid")
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void forbid() {
    }

    // /api/demo/status/notfound

    @GetMapping("/api/demo/status/internalservererror")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void return500() {
    }

    @GetMapping("/api/demo/delay/{seconds}")
    public String delayBy(@PathVariable long seconds) throws InterruptedException {
        Instant start = Instant.now();
        TimeUnit.SECONDS.sleep(seconds);
        Instant end = Instant.now();
        return "Started on " + start.toString() + "completed on " + end.toString();
    }

    @GetMapping("/api/demo/exception/handled")
    public String handledException() throws Exception {
        try {
            DemoController demo = null;
            return demo.ping();
        }
        catch(Exception e){
            return e.getMessage();
        }
    }

    @GetMapping("/api/demo/exception/unhandled")
    public List<String> unhandledException() {
        List<String> names = null;
        names.add("Bill Gates");
        return names;
    }

    @GetMapping("/api/demo/shutdown")
    public void shutdown() {
        System.exit(0);
    }

    @GetMapping("/api/demo/heapdump")
    public void dumpHeap() {
		List<Integer> list = new ArrayList<>();

		Random random = new Random();

        long i = 0;
        while (true) {
        System.out.println(i++);
        list.add(random.nextInt());
        }
	}
}