'use strict';

/* https://github.com/angular/protractor/blob/master/docs/toc.md */

describe('cmdController', function() {


  it('should ...', function() {
    browser.get('commande.html');
    var elts = element.all(by.repeater('produit in produits'));
    expect(elts.count()).toEqual(3);
  });

});
