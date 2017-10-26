import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { JhiEventManager, JhiParseLinks, JhiAlertService } from 'ng-jhipster';

import { Parcours } from './parcours.model';
import { ParcoursService } from './parcours.service';
import { ITEMS_PER_PAGE, Principal, ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-parcours',
    templateUrl: './parcours.component.html'
})
export class ParcoursComponent implements OnInit, OnDestroy {
parcours: Parcours[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private parcoursService: ParcoursService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.parcoursService.query().subscribe(
            (res: ResponseWrapper) => {
                this.parcours = res.json;
            },
            (res: ResponseWrapper) => this.onError(res.json)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInParcours();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: Parcours) {
        return item.id;
    }
    registerChangeInParcours() {
        this.eventSubscriber = this.eventManager.subscribe('parcoursListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
