import { BaseEntity } from './../../shared';

export class Ville implements BaseEntity {
    constructor(
        public id?: number,
        public imageContentType?: string,
        public image?: any,
        public nom?: string,
        public pays?: string,
        public description?: string,
        public parcours?: BaseEntity[],
        public site?: BaseEntity,
    ) {
    }
}
