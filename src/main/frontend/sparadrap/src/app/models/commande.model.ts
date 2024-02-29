import {Client} from "./client.model";

export class Commande{
  com_id?: number;
  clientId: number;
  date: string | undefined;
  ordonnance: boolean;

  constructor() {
    this.com_id = 0;
    this.clientId = 0;
    this.date= '';
    this.ordonnance= false;
  }
}
