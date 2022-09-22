import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductListComponent } from './product-list/product-list.component';

import { ConvertToSpacesPipe } from 'src/app/convert-to-spaces.pipe';



@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ConvertToSpacesPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ConvertToSpacesPipe
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
