import { BaseEntity } from './../../shared';

export class Site implements BaseEntity {
    constructor(
        public id?: number,
        public nom?: string,
        public lienUrl?: string,
        public prix?: number,
        public description?: string,
        public adresse?: string,
        public parcours?: BaseEntity[],
    ) {
    }
}
