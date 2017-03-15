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
		
		var ajoutEmrpuntUrl = rootUrl+"/resource/emprunt.ajout";// POST id_adherent,id_media, depart	
		
		this.getPromise = function(url){
			 return $http.get(url).then(function(response){
				return response.data;
			},function(){
				console.log('Flûte alors... plus d\'internet mondiale :/');
			});
		}
		
		this.getPromiseWithParams = function(url,params){
			 return $http.get(url,{ "params" : params}).then(function(response){
				return response.data;
			},function(){
				console.log('Flûte alors... plus d\'internet mondiale :/');
			});
		}
		
		this.getMedias = function(){
			return self.getPromise(mediaRechercheUrl);
		}
		
		this.getMediaById = function(id){
			return self.getPromise(mediaAccessionUrl+"?id="+id);
		}
		
		this.addMedia = function(newMedia){
			return $http.post(mediaCreationUrl,newMedia);
		}
		
		this.updateMedia = function(media){
			$http.post(mediaModificationUrl,media);
		}
		
		this.getMediasByParams = function(params){
			return self.getPromiseWithParams(mediaRechercheUrl,params);
		}
		
		this.getAdherents = function(){
			return self.getPromise(adherentRechercheUrl);
		}
		
		this.getAdherentById = function(id){
			return self.getPromise(adherentAccessionUrl+"?id="+id);
		}
		
		this.addAdherent = function(newAdherent){
			$http.post(adherentCreationUrl,newAdherent);
		}
		
		this.updateAdherent = function(adherent){
			$http.post(adherentModificationUrl,adherent);
		}
		
		this.getAdherentsByParams = function(params){
			return self.getPromiseWithParams(adherentRechercheUrl,params);
		}
		
		this.addEmpruntMedia = function(idAdherent, idMedia, dateDepart){
			$http.post(ajoutEmrpuntUrl,{id_adherent:idAdherent,id_media:idMedia,depart:dateDepart});
		}
		
		this.getConnection = function(){
			return rootUrl+'/resource/connexion.rights';
		}
			
	});
	
})();
