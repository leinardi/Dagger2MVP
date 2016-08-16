package com.leinardi.dagger2mvp.dagger;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by leinardi on 13/07/16.
 */

@Qualifier
@Retention(RUNTIME)
public @interface ForApplication {
}
