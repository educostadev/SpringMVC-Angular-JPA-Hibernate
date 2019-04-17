# SpringMVC-Angular-JPA-Hibernate
Sample of CRUP application using Spring MVC + Angular + REST API + JPA/Hibernate.

The original tutorial for this sample is available on [Youtube](https://www.youtube.com/watch?v=PQmu752Ifn8&feature=youtu.be) and on author´s github [backend](https://github.com/scbushan05/spring-boot-hibernate-mysql-rest-api) [frontend](https://github.com/scbushan05/angular-2-crud).



## Useful commands for Frontend project 

- Angular CLI: 7.3.8 / Node 11.13.0
- ng new <new-projectname>
- ng serve --open

## Issues fixed due the upgrade to Angular 7

- [Used`@angular/common/http` instead of `Http`.](https://discourse.nativescript.org/t/http-is-not-found-in-angular-http/3140/2)
- [Fixed the error Property 'map' does not exist on type 'Observable<Response>'.](https://medium.com/coding-snippets/rxjs-5-5-property-map-does-not-exist-on-type-observable-e825129c2068)
- [Used catchError instead of catch on BookService](https://stackoverflow.com/questions/47538060/how-to-catch-error-in-rxjs-5-5?rq=1)
- [Fixed the use of HttpClient to get Observable<Book>](https://www.concretepage.com/angular-2/angular-httpclient-get-example#async)
- [Example of use HttpClient](https://www.concretepage.com/angular-2/angular-httpclient-get-example#async)

