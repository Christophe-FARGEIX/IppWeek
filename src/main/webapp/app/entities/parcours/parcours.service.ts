import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { SERVER_API_URL } from '../../app.constants';

import { Parcours } from './parcours.model';
import { ResponseWrapper, createRequestOption } from '../../shared';

@Injectable()
export class ParcoursService {

    private resourceUrl = SERVER_API_URL + 'api/parcours';

    constructor(private http: Http) { }

    create(parcours: Parcours): Observable<Parcours> {
        const copy = this.convert(parcours);
        return this.http.post(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            return this.convertItemFromServer(jsonResponse);
        });
    }

    update(parcours: Parcours): Observable<Parcours> {
        const copy = this.convert(parcours);
        return this.http.put(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            return this.convertItemFromServer(jsonResponse);
        });
    }

    find(id: number): Observable<Parcours> {
        return this.http.get(`${this.resourceUrl}/${id}`).map((res: Response) => {
            const jsonResponse = res.json();
            return this.convertItemFromServer(jsonResponse);
        });
    }

    query(req?: any): Observable<ResponseWrapper> {
        const options = createRequestOption(req);
        return this.http.get(this.resourceUrl, options)
            .map((res: Response) => this.convertResponse(res));
    }

    delete(id: number): Observable<Response> {
        return this.http.delete(`${this.resourceUrl}/${id}`);
    }

    private convertResponse(res: Response): ResponseWrapper {
        const jsonResponse = res.json();
        const result = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            result.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return new ResponseWrapper(res.headers, result, res.status);
    }

    /**
     * Convert a returned JSON object to Parcours.
     */
    private convertItemFromServer(json: any): Parcours {
        const entity: Parcours = Object.assign(new Parcours(), json);
        return entity;
    }

    /**
     * Convert a Parcours to a JSON which can be sent to the server.
     */
    private convert(parcours: Parcours): Parcours {
        const copy: Parcours = Object.assign({}, parcours);
        return copy;
    }
}
