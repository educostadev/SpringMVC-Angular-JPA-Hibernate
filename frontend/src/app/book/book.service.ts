import { Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpResponse, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from "rxjs/operators";
import { filter } from "rxjs/operators";
import { first } from "rxjs/operators";
import { catchError } from "rxjs/operators"
//import 'rxjs/add/operator/map';
//import 'rxjs/add/operator/catch';
import { Book } from './book';


@Injectable()
export class BookService implements OnInit {

    ngOnInit(): void {
        console.log(this.getAllBooks());
    }


    constructor(private _httpService: HttpClient) { }

    getAllBooks(): Observable<Book[]> {
        console.log("inside the service getAllBooks():::::::");
        return this._httpService.get<Book[]>("http://localhost:8080/bookapi/api/book");
    }

    getBookById(bookId: string): Observable<Book> {
        console.log("Inside the getBookById() service::::::");
        return this._httpService.get<Book>("http://localhost:8080/bookapi/api/book/" + bookId);
    }

    addBook(book: Book) {
        let body = JSON.parse(JSON.stringify(book));
        let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
        //let options = new RequestOptions({ headers: headers });
        let options = { headers: headers }
        if (book.id) {
            console.log("Inside addBook update service():::::::");
            return this._httpService.put("http://localhost:8080/bookapi/api/book/" + book.id, body, options);
        } else {
            console.log("Inside addBook add service():::::::");
            return this._httpService.post("http://localhost:8080/bookapi/api/book", body, options);
        }
    }

    deleteBook(bookId: string) {
        console.log("Inside the service deleteBook():::::book id:::" + bookId);
        return this._httpService.delete("http://localhost:8080/bookapi/api/book/" + bookId);
    }

    private handleError(error: Response) {
        console.error(error);
        return Observable.throw(error);
    }


    private createRequestHeader() {
        // set headers here e.g.
        let headers = new HttpHeaders({
            "AuthKey": "my-key",
            "AuthToken": "my-token",
            "Content-Type": "application/json",
        });

        return headers;
    }

    hasValue(value: any) {
        return value !== null && value !== undefined;
    }

    getValue<T>(observable: Observable<T>) {
        return observable
            .pipe(
                filter(this.hasValue),
                first()
            )
            .toPromise();
    }
}