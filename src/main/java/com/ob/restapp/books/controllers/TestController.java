package com.ob.restapp.books.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
public class TestController {
  
  @Value("${app.message}")
  String message;
  
  @GetMapping("/hola")
  public String sayHi() {
    return "Hola, nos vemos en el fin del mundo " + message;
  }
  
  @GetMapping("/bootstrap")
  public String bootstrap() {
    return """
        ""<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap w/ Vite</title>
    <link rel="stylesheet" href="scss/styles.scss">
    <script type="module" src="./js/main.js"></script>
  </head>
  <body>
    <div class="container py-4 px-3 mx-auto">
      <header class="d-flex justify-content-between align-items-md-center pb-3 mb-5 border-bottom">
        <h1 class="h4">
          <a href="/" class="d-flex align-items-center text-dark text-decoration-none">
            <img class="d-inline-block me-2" width="40" height="32" src="https://raw.githubusercontent.com/twbs/bootstrap/main/site/static/docs/5.2/assets/brand/bootstrap-logo-black.svg" alt="Bootstrap">
            <span>Vite</span>
          </a>
        </h1>
        <a href="https://github.com/twbs/examples/tree/main/vite/" target="_blank" rel="noopener">View on GitHub</a>
      </header>

      <h1>Build Bootstrap with Vite</h1>
      <div class="col-lg-8 px-0">
        <p class="fs-4">You've successfully loaded the Bootstrap + Vite example! It's loaded up with <a href="https://getbootstrap.com/">Bootstrap 5</a> and uses Vite to compile and bundle our Sass and JavaScript.</p>
        <p>If this button appears blue and the link appears purple, you've done it!</p>
      </div>

      <button type="button" class="btn btn-primary me-3" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample">Toggle offcanvas</button>
      <a id="popoverButton" class="text-success" href="#" role="button" data-bs-toggle="popover" title="Custom popover" data-bs-content="This is a Bootstrap popover.">Example popover</a>

      <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
        <div class="offcanvas-header">
          <h5 class="offcanvas-title" id="offcanvasExampleLabel">Offcanvas</h5>
          <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>
        <div class="offcanvas-body">
          <div>
            Some text as placeholder. In real life you can have the elements you have chosen. Like, text, images, lists, etc.
          </div>
          <div class="dropdown mt-3">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown">
              Dropdown button
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
              <li><a class="dropdown-item" href="#">Action</a></li>
              <li><a class="dropdown-item" href="#">Another action</a></li>
              <li><a class="dropdown-item" href="#">Something else here</a></li>
            </ul>
          </div>
        </div>
      </div>

      <hr class="col-1 my-5 mx-0">

      <h2>Guides</h2>
      <p>Read more detailed instructions and documentation on using or contributing to Bootstrap.</p>
      <ul class="icon-list">
        <li><a href="https://getbootstrap.com/docs/5.2/getting-started/introduction/">Bootstrap quick start guide</a></li>
        <li><a href="https://getbootstrap.com/docs/5.2/getting-started/webpack/">Bootstrap Webpack guide</a></li>
        <li><a href="https://getbootstrap.com/docs/5.2/getting-started/parcel/">Bootstrap Parcel guide</a></li>
        <li><a href="https://getbootstrap.com/docs/5.2/getting-started/vite/">Bootstrap Vite guide</a></li>
        <li><a href="https://getbootstrap.com/docs/5.2/getting-started/build-tools/">Contributing to Bootstrap</a></li>
      </ul>

      <hr class="mt-5 mb-4">

      <p class="text-muted">Created and open sourced by the Bootstrap team. Licensed MIT.</p>
    </div>
  </body>
</html>""";
  }
}
