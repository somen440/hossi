import { commonConfig } from "./default";
import { Env, envConfig } from "./environment";

interface Config {
  // common config
  port: string

  // envieonment config
  env: string
  debuggable: boolean
}

const ec = envConfig(process.env.NODE_ENV as Env || "development");

export const config: Config = {
  port: commonConfig.port,

  env: ec.env,
  debuggable: ec.debuggable,
}

export function toMaskConfig(config: Config): string {
  return `port=${config.port} env=${config.env} debuggable=${config.debuggable}`
}
