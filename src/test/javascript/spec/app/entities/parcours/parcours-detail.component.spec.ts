/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils, JhiDataUtils, JhiEventManager } from 'ng-jhipster';
import { IppWeekTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { ParcoursDetailComponent } from '../../../../../../main/webapp/app/entities/parcours/parcours-detail.component';
import { ParcoursService } from '../../../../../../main/webapp/app/entities/parcours/parcours.service';
import { Parcours } from '../../../../../../main/webapp/app/entities/parcours/parcours.model';

describe('Component Tests', () => {

    describe('Parcours Management Detail Component', () => {
        let comp: ParcoursDetailComponent;
        let fixture: ComponentFixture<ParcoursDetailComponent>;
        let service: ParcoursService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [IppWeekTestModule],
                declarations: [ParcoursDetailComponent],
                providers: [
                    JhiDateUtils,
                    JhiDataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    ParcoursService,
                    JhiEventManager
                ]
            }).overrideTemplate(ParcoursDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(ParcoursDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(ParcoursService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new Parcours(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.parcours).toEqual(jasmine.objectContaining({id: 10}));
            });
        });
    });

});
