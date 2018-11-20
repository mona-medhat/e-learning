package com.eng.asu.adaptivelearning.dagger;


import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponents {
}
