export interface MicroService {
  name: string;
  instances: MicroServiceInstance[];
}

export interface MicroServiceInstance {
  url: string;
  status: string;
}
