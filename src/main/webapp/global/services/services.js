(function(){
	'use strict';
	
	angular.module('mediaticApp.service')
	.service('ServiceUrl',function($http){
		
		var self = this;
		
		var rootUrl = "http://192.168.10.17:8090";
		var mediaRechercheUrl = rootUrl+"/resource/media.recherche";// GET page, titre, auteur,type,tri:(id,titre,auteur)
		var mediaCreationUrl = rootUrl+"/resource/media.creation";// POST
		var mediaModificationUrl = rootUrl+"/resource/media.modification";// GET
		var mediaAccessionUrl = rootUrl+"/resource/media.accession";// GET
		
		var adherentRechercheUrl = rootUrl+"/resource/adherent.recherche";// GET page,id,nom,prenom,email,texte nom prenom,tri : (id,nom,prenom,email,-id,-nom,-prenom,-email)
		var adherentCreationUrl = rootUrl+"/resource/adherent.creation";// POST
		var adherentModificationUrl = rootUrl+"/resource/adherent.modification";// GET
		var adherentAccessionUrl = rootUrl+"/resource/adherent.accession";// GET
		
		var ajoutEmrpuntUrl = rootUrl+"/resource/emprunt.ajout";// POST id_adherent,id_media,depart	
		
		this.getPromise = function(url){
			var data;
			 return $http.get(url).then(function(response){
				return response.data;
			},function(){
				console.log('Flûte alors... plus d\'internet mondiale :/');
			});
			 return data;
		}
		
		this.getMediaRecherche = function(){
			return self.getPromise(mediaRechercheUrl);
		}
		
		
	});
	
})();
