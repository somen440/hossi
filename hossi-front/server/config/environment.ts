export interface EnvConfig {
  env: Env
  debuggable: boolean
}

export type Env = "development" | "production";

const development: EnvConfig = {
  env: "development",
  debuggable: true,
}

const production: EnvConfig = {
  env: "production",
  debuggable: false,
}

export function envConfig(env: Env): EnvConfig {
  if (env == "production") {
    return production;
  }
  return development;
}
