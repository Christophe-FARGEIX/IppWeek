import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { JhiEventManager } from 'ng-jhipster';

import { Parcours } from './parcours.model';
import { ParcoursService } from './parcours.service';

@Component({
    selector: 'jhi-parcours-detail',
    templateUrl: './parcours-detail.component.html'
})
export class ParcoursDetailComponent implements OnInit, OnDestroy {

    parcours: Parcours;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private parcoursService: ParcoursService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInParcours();
    }

    load(id) {
        this.parcoursService.find(id).subscribe((parcours) => {
            this.parcours = parcours;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInParcours() {
        this.eventSubscriber = this.eventManager.subscribe(
            'parcoursListModification',
            (response) => this.load(this.parcours.id)
        );
    }
}
